package beans;

import models.Reader;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

@Named
@SessionScoped
public class ReaderBean implements Serializable {

    public Reader queryObject;

    public String result;

    private String readerName;

    private String readerPassword;

    public void getPropiedadesInicioSesion() {
        ResourceBundle bundle = ResourceBundle.getBundle("blog");
        readerName = bundle.getString("reader.name");
        readerPassword = bundle.getString("reader.password");
        queryObject = new Reader();
    }

    public ReaderBean() {
        getPropiedadesInicioSesion();
    }

    public void login(){
        if(queryObject.getName().equals(this.readerName) && queryObject.getPassword().equals(this.readerPassword)){
            this.result = "Inicio Exitoso!!!";
        }
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
