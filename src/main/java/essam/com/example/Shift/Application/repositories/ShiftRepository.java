package essam.com.example.Shift.Application.repositories;

import essam.com.example.Shift.Application.enums.ShiftStatus;
import essam.com.example.Shift.Application.models.Shift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    Page<Shift> findAllByStatus(ShiftStatus status, Pageable pageable);
}
