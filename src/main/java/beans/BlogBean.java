package beans;

import daos.BlogDao;
import models.Blog;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BlogBean implements Serializable  {

    private static final long serialVersionUID = 1376319740144826761L;

    @Inject
    private BlogDao dao;

    private Blog queryObject;

    private List<Blog> blogs;

    public BlogBean() {
        queryObject = new Blog();
    }

    public String buscarBlogs() {
        try {
            if (dao != null) {
                this.blogs = dao.getAllBlogs();
            } else {
                // Manejo de excepción: El objeto dao es nulo
                // Puedes registrar un mensaje de error o realizar otras acciones aquí
                System.err.println("El objeto dao es nulo");
            }
        } catch (Exception e) {
            // Manejo de excepción en caso de error al obtener los blogs
            e.printStackTrace(); // Opcional: Imprime la traza de la excepción
            // Puedes registrar un mensaje de error o realizar otras acciones aquí
        }
        return null;
    }


    public Blog getQueryObject() {
        return queryObject;
    }

    public void setQueryObject(Blog queryObject) {
        this.queryObject = queryObject;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public void setDao(BlogDao dao) {
        this.dao = dao;
    }
}
