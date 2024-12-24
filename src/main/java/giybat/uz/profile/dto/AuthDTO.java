package giybat.uz.profile.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class AuthDTO {
    @NotBlank(message = "Username  not blank")
    private String username;
    @NotBlank(message = "Password not blank")
    private String password;

    public @NotBlank(message = "Password not blank") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password not blank") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Username  not blank") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username  not blank") String username) {
        this.username = username;
    }
}
