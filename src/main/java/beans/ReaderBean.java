package beans;

import daos.ReaderDao;
import models.Reader;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ResourceBundle;

@Named
@ApplicationScoped
public class ReaderBean implements Serializable {

    private static final long serialVersionUID = 7127319740144826061L;

    @Inject
    private ReaderDao dao;

    private Reader queryObject;

    private Reader object;

    private String name;

    private String password;

    private String result;

    private String readerName;

    private String readerPassword;

    private ArrayList<Reader> readers;

    public ReaderBean() {
    }

    @PostConstruct
    public void getPropiedadesInicioSesion() {
        ResourceBundle bundle = ResourceBundle.getBundle("blog");
        readerName = bundle.getString("reader.name");
        readerPassword = bundle.getString("reader.password");
        queryObject = new Reader();
        object = new Reader();
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

    public String regresarConsulta() {
        try {
            return "consultarReader";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String buscarReaders() {
        try {
            this.readers = (ArrayList<Reader>) dao.getAllReaders(queryObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void limpiarForm() {
        this.queryObject = new Reader();
        this.readers = new ArrayList<>();
    }

    public String enviarEditar(Long id) {
        try {
            this.object = id != null ? this.readers.stream()
                    .filter(blog -> blog.getId() == id)
                    .findFirst()
                    .orElse(null)
                    : new Reader();

            return "editarReader";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String actualizarReader() {
        try {
            if(this.object.getId() > 0){
                dao.updateReader(this.object);
            }
            else {
                dao.createReader(this.object);
            }

            this.buscarReaders();
            return regresarConsulta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String borrarReader(Long id) {
        try {
            dao.deleteReader(id);

            this.buscarReaders();
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

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(ArrayList<Reader> readers) {
        this.readers = readers;
    }

    public Reader getObject() {
        return object;
    }

    public void setObject(Reader object) {
        this.object = object;
    }
}
