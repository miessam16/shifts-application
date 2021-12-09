package essam.com.example.Shift.Application.repositories;

import essam.com.example.Shift.Application.enums.ShiftStatus;
import essam.com.example.Shift.Application.models.Shift;
import essam.com.example.Shift.Application.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    Page<Shift> findAllByStatus(ShiftStatus status, Pageable pageable);
    @Query(
            value = "select count(*) from shifts " +
                    "where assignee_id = ?1 and status != 'SCHEDULED' " +
                    "and (" +
                    "(start_time <= ?2 and end_time >= ?2) or " +
                    "(start_time <= ?3 and end_time >= ?3) or " +
                    "(start_time >= ?2 and end_time <= ?3)" +
                    ")",
            nativeQuery = true
    )
    Integer countByAssigneeInRange(Long assigneeId, Date startTime, Date endTime);
    Optional<Shift> findByIdAndCreator(Long id, User creator);
}
