package giybat.uz.Attach.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
//@Getter
//@Setter
public class DovnloadDTO {
    private String Name;
    private Resource resource;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
