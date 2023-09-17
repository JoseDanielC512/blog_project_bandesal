package beans;

import models.Reader;

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

    private String result;

    private String readerName;

    private String readerPassword;

    public ReaderBean() {
        getPropiedadesInicioSesion();
    }

    public void getPropiedadesInicioSesion() {
        ResourceBundle bundle = ResourceBundle.getBundle("blog");
        readerName = bundle.getString("reader.name");
        readerPassword = bundle.getString("reader.password");
        queryObject = new Reader();
    }

    public String login() {
        try {
            if (queryObject.getName().equals(this.readerName) && queryObject.getPassword().equals(this.readerPassword)) {
                return "loginSuccess"; // Este es el outcome definido en el faces-config.xml
            } else {
                throw new Exception("Credenciales inválidas");
            }
        } catch (Exception e) {
            this.result = "Error al iniciar sesión: " + e.getMessage();
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

    // Métodos para acceder a los EJBs y operar sobre las entidades

    // ...
}
