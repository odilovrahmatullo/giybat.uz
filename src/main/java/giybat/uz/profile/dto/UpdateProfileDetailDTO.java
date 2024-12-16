package giybat.uz.profile.dto;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class UpdateProfileDetailDTO {
    private String name;
    private String surname;
    private String photoId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
