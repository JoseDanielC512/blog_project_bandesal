package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BLOGS_READERS")
public class BlogsReaders implements Serializable {

    @Column(name = "R_ID")
    long r_id;

    @Column(name = "B_ID")
    long b_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "B_ID")
    private Blog blog;

    @Id
    @ManyToOne
    @JoinColumn(name = "R_ID")
    private Reader reader;

    public BlogsReaders() {
    }

    public long getR_id() {
        return r_id;
    }

    public void setR_id(long r_id) {
        this.r_id = r_id;
    }

    public long getB_id() {
        return b_id;
    }

    public void setB_id(long b_id) {
        this.b_id = b_id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}