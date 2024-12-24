package giybat.uz.UsernameHistory.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsAuthResponseDTO {
    private SmsAuthTokenDTO data;

    public SmsAuthTokenDTO getData() {
        return data;
    }

    public void setData(SmsAuthTokenDTO data) {
        this.data = data;
    }
}

