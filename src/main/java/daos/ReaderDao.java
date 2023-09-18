package daos;

import models.Reader;

import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ViewScoped
public class ReaderDao implements Serializable {

    private static final long serialVersionUID = -4250857462735843811L;

    @PersistenceContext
    private EntityManager em = JPAConfig.getEntityManagerFactory().createEntityManager();

    public List<Reader> getAllReaders(Reader reader) {
        List<Reader> result = new ArrayList<Reader>();
        List<Reader> list = null;

        StringBuffer sql = new StringBuffer();
        Query query = null;
        Map<String, Object> map = new HashMap<String, Object>();

        sql.append("SELECT t FROM ");
        sql.append(Reader.class.getCanonicalName());
        sql.append(" t WHERE 1 = 1 ");

        if (reader.getId() > 0) {
            sql.append(" AND t.id = :id ");
            map.put("id", reader.getId());
        }

        if (reader.getName() != null && !reader.getName().isEmpty()) {
            sql.append(" AND t.name = :name ");
            map.put("name", reader.getName());
        }

        sql.append(" ORDER BY t.id ");
        query = em.createQuery(sql.toString());
        for (Map.Entry<String, Object> valor : map.entrySet()) {
            query.setParameter(valor.getKey(), valor.getValue());
        }

        return query.getResultList();
    }

    public void createReader(Reader reader) {
        em.getTransaction().begin();
        em.persist(reader);
        em.getTransaction().commit();
    }

    public Reader getReaderById(Long id) {
        return em.find(Reader.class, id);
    }

    public void updateReader(Reader reader) {
        em.getTransaction().begin();
        em.merge(reader);
        em.getTransaction().commit();
    }

    public void deleteReader(Long id) {
        em.getTransaction().begin();
        Reader reader = em.find(Reader.class, id);
        if (reader != null) {
            em.remove(reader);
        }
        em.getTransaction().commit();
    }
}

