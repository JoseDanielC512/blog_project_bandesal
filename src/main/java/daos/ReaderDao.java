package daos;

import models.Reader;

import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ViewScoped
public class ReaderDao {

    @PersistenceContext
    private EntityManager em;

    public List<Reader> getAllReaders() {
        return em.createQuery("SELECT r FROM Reader r", Reader.class).getResultList();
    }

    public void createReader(Reader reader) {
        em.persist(reader);
    }

    public Reader getReaderById(Long id) {
        return em.find(Reader.class, id);
    }

    public void updateReader(Reader reader) {
        em.merge(reader);
    }

    public void deleteReader(Long id) {
        Reader reader = em.find(Reader.class, id);
        if (reader != null) {
            em.remove(reader);
        }
    }
}

