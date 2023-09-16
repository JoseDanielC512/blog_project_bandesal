package daos;

import models.BlogsReaders;

import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ViewScoped
public class BlogsReadersDao {

    @PersistenceContext
    private EntityManager em;

    public void addReaderToBlog(BlogsReaders obj) {
        em.persist(obj);
    }

    public void removeReaderFromBlog(BlogsReaders obj) {
        em.remove(em.merge(obj));
    }
}

