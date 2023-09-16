package models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "READERS")
public class Reader implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    long id;

    @Column(name = "NAME")
    String name;

    public Reader() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}