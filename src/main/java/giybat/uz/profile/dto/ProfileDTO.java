package giybat.uz.profile.dto;


import giybat.uz.Attach.entity.AttachEntity;
import giybat.uz.profile.entity.ProfileEntity;
import giybat.uz.profile.enums.ProfileRole;
import giybat.uz.profile.enums.ProfileStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {

    private Integer id;
    @NotBlank(message = "Name not found")
    private String name;
    @NotBlank(message = "Surname not found")
    private String surname;
    @NotBlank(message = "Email not found")
    private String username;
    @NotBlank(message = "Password not found")
    private String password;
    private AttachEntity photo;
    private ProfileStatus status;
    private ProfileRole role;
    private String JwtToken;
    private String refreshToken;


    public ProfileEntity mapToEntity() {
        return ProfileEntity.builder()
                .name(this.getName())
                .surname(this.getSurname())
                .password(this.getPassword())
                .role(this.getRole())
                .username(this.getUsername())
                .status(this.getStatus())
                .created_date(LocalDateTime.now())
                .visible(Boolean.TRUE)
                .build();
    }
}
