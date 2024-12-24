package giybat.uz.profile.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class RegistrationDTO {

    @NotBlank(message = "Enter your name")
    private String name;
    @NotBlank(message = "Enter your surname")
    private String surname;
    @NotBlank(message = "Enter your username")
    private String username;
    @NotBlank(message = "Enter your password")
    private String password;

    public @NotBlank(message = "Enter your name") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Enter your name") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Enter your password") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Enter your password") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Enter your surname") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Enter your surname") String surname) {
        this.surname = surname;
    }

    public @NotBlank(message = "Enter your username") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Enter your username") String username) {
        this.username = username;
    }
}
