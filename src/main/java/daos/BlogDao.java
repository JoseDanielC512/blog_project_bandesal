package daos;

import models.Blog;

import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@ViewScoped
public class BlogDao implements Serializable {

    private static final long serialVersionUID = -5850137462735843811L;

    @PersistenceContext
    private final EntityManager em = JPAConfig.getEntityManagerFactory().createEntityManager();

    public List<Blog> getAllBlogs() {
        return em.createQuery("SELECT b FROM Blog b", Blog.class).getResultList();
    }

    public void createBlog(Blog blog) {
        em.getTransaction().begin();
        em.persist(blog);
        em.getTransaction().commit();
    }

    public Blog getBlogById(Long id) {
        return em.find(Blog.class, id);
    }

    public void updateBlog(Blog blog) {
        em.getTransaction().begin();
        em.merge(blog);
        em.getTransaction().commit();
    }

    public void deleteBlog(Long id) {
        em.getTransaction().begin();
        Blog blog = em.find(Blog.class, id);
        if (blog != null) {
            em.remove(blog);
        }
        em.getTransaction().commit();
    }
}

