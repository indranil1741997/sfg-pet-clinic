package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id = null;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
