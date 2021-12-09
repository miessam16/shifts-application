package essam.com.example.Shift.Application.requests;

import essam.com.example.Shift.Application.validators.UniquePhoneNumber;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {
    @NotBlank()
    @Size(min = 4)
    private String name;

    @NotBlank()
    @Size(min = 4)
    private String bio;

    @NotBlank()
    @Size(min = 4)
    @UniquePhoneNumber
    @Pattern(regexp = "(\\+966)[0-9]{9}")
    private String phoneNumber;

    @NotBlank()
    @Size(min = 6)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
