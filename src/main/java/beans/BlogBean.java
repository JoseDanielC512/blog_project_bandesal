package beans;

import models.Blog;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BlogBean implements Serializable  {

    @Inject
    private BlogBean blogBean;

    private List<Blog> allBlogs;

    // Métodos para acceder a los EJBs y operar sobre las entidades

    // ...
}
