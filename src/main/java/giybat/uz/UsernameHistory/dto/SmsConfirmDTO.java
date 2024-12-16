package giybat.uz.UsernameHistory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsConfirmDTO {
    private String phone;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
