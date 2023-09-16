package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BLOGS")
public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    long id;

    @Column(name = "TITLE")
    String title;

    @Column(name = "DESCRIPTION")
    String description;

    public Blog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}