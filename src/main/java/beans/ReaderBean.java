package beans;

import models.Reader;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

@Named
@ViewScoped
public class ReaderBean implements Serializable {

    private static final long serialVersionUID = 7127319740144826061L;

    private Reader queryObject;

    private String name;

    private String password;

    private String result;

    private String readerName;

    private String readerPassword;

    public ReaderBean() {
    }

    @PostConstruct
    public void getPropiedadesInicioSesion() {
        ResourceBundle bundle = ResourceBundle.getBundle("blog");
        readerName = bundle.getString("reader.name");
        readerPassword = bundle.getString("reader.password");
        queryObject = new Reader();
    }

    public String login() {
        try {
            if (name.equals(this.readerName) && password.equals(this.readerPassword)) {
                return "loginSuccess"; // Este es el outcome definido en el faces-config.xml
            } else {
                throw new Exception("Credenciales inválidas");
            }
        } catch (Exception e) {
            this.result = "Error al iniciar sesión: " + e.getMessage();
        }
        return null;
    }

    public String irMenuPrincipal() {
        try {
            return "menuPrincipal";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String irBlogs() {
        try {
            return "consultarBlog";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Reader getQueryObject() {
        return queryObject;
    }

    public void setQueryObject(Reader queryObject) {
        this.queryObject = queryObject;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private List<Reader> allReaders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
