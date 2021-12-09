package essam.com.example.Shift.Application.requests;

import javax.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;

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
