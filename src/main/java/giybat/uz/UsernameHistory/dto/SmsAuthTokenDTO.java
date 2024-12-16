package giybat.uz.UsernameHistory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsAuthTokenDTO {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
