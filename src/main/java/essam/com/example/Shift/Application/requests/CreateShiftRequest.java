package essam.com.example.Shift.Application.requests;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateShiftRequest {
    @NotNull()
    @Future()
    private Date startTime;

    @NotNull()
    @Future()
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
