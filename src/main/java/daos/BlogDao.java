package daos;

import models.Blog;

import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ViewScoped
public class BlogDao {

    @PersistenceContext
    private EntityManager em;

    public List<Blog> getAllBlogs() {
        return em.createQuery("SELECT b FROM Blog b", Blog.class).getResultList();
    }

    public void createBlog(Blog blog) {
        em.persist(blog);
    }

    public Blog getBlogById(Long id) {
        return em.find(Blog.class, id);
    }

    public void updateBlog(Blog blog) {
        em.merge(blog);
    }

    public void deleteBlog(Long id) {
        Blog blog = em.find(Blog.class, id);
        if (blog != null) {
            em.remove(blog);
        }
    }
}

