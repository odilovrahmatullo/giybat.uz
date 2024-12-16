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

//@Getter
//@Setter
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJwtToken() {
        return JwtToken;
    }

    public void setJwtToken(String jwtToken) {
        JwtToken = jwtToken;
    }

    public @NotBlank(message = "Name not found") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name not found") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Password not found") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password not found") String password) {
        this.password = password;
    }

    public AttachEntity getPhoto() {
        return photo;
    }

    public void setPhoto(AttachEntity photo) {
        this.photo = photo;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public ProfileRole getRole() {
        return role;
    }

    public void setRole(ProfileRole role) {
        this.role = role;
    }

    public ProfileStatus getStatus() {
        return status;
    }

    public void setStatus(ProfileStatus status) {
        this.status = status;
    }

    public @NotBlank(message = "Surname not found") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Surname not found") String surname) {
        this.surname = surname;
    }

    public @NotBlank(message = "Email not found") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Email not found") String username) {
        this.username = username;
    }

    public ProfileEntity mapToEntity() {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName(this.getName());
        profileEntity.setSurname(this.getSurname());
        profileEntity.setPassword(this.getPassword());
        profileEntity.setRole(this.getRole());
        profileEntity.setUsername(this.getUsername());
        profileEntity.setStatus(this.getStatus());
        profileEntity.setCreated_date(LocalDateTime.now());
        profileEntity.setVisible(Boolean.TRUE);
        return profileEntity;
    }
}
