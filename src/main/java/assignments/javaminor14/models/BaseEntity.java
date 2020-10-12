package assignments.javaminor14.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    private long id;

    @Version
    private Integer version;

    @CreatedDate
    private LocalDate createdDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDate getCreationDate() {
        return createdDate;
    }
}
