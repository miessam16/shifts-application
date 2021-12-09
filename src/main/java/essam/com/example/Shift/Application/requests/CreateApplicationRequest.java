package essam.com.example.Shift.Application.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateApplicationRequest {
    @NotNull
    @Min(1)
    private double proposedRate;

    @NotBlank
    private String coverLetter;

    public double getProposedRate() {
        return proposedRate;
    }

    public String getCoverLetter() {
        return coverLetter;
    }
}
