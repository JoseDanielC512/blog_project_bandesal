package beans;

import models.Reader;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ReaderBean implements Serializable {

    @Inject
    private ReaderBean readerBean;

    private List<Reader> allReaders;

    // Métodos para acceder a los EJBs y operar sobre las entidades

    // ...
}
