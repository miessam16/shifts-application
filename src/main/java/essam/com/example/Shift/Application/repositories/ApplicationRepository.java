package essam.com.example.Shift.Application.repositories;

import essam.com.example.Shift.Application.models.Application;
import essam.com.example.Shift.Application.models.Shift;
import essam.com.example.Shift.Application.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public boolean existsByApplicantAndShift(User applicant, Shift shift);
    public Page<Application> findAllByShift(Shift shift, Pageable pageable);
    public Page<Application> findAllByApplicant(User user, Pageable pageable);
    @Transactional
    @Modifying
    @Query(
            value = "delete from applications " +
            "where applicant_id = ?1 and " +
            "shift_id in (select id from shifts where assignee_id = ?1 " +
                    "and (  " +
                    "(start_time <= ?2 and end_time >= ?2) or " +
                    "(start_time <= ?3 and end_time >= ?3) or " +
                    "(start_time >= ?2 and end_time <= ?3)" +
                    "))",
            nativeQuery = true
    )
    public int deleteByApplicantInRange(Long applicantId, Date startTime, Date endTime);
}
