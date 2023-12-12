package cesur.examen.domain.client;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:
 * Fecha:
 */

@Log
public class ClientDAO implements DAO<Client> {
    @Override
    public Client save(Client client) {

        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = null;
            try {
                t = session.beginTransaction();
                session.persist(client);
                t.commit();
            } catch (Exception e) {
                if (t != null) {
                    t.rollback();
                }
                e.printStackTrace();
            }
        }
        return client;
    }
    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public boolean remove(Client client) {
        return false;
    }

    @Override
    public Client get(Long id) {
        return null;
    }


    @Override
    public List<Client> getAll() {
        var out = new ArrayList<Client>();


            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Query<Client> q = session.createQuery("FROM cliente" ,Client.class);
                out= (ArrayList<Client>) q.getResultList();
            }
            return out;


    }

}
