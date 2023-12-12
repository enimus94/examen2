package cesur.examen.domain.car;

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
 * Nombre del alumno:Cayetano Perez Bueno
 * Fecha:
 */

@Log
public class CarDAO implements DAO<Car> {
    @Override
    public Car save(Car car) {

        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = null;
            try {
                t = session.beginTransaction();
                session.persist(car);
                t.commit();
            } catch (Exception e) {
                if (t != null) {
                    t.rollback();
                }
                e.printStackTrace();
            }
        }

        return car;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    public List<Car> getAllByManufacturer(String manufacturer){
        var out = new ArrayList<Car>();
            var salida = new ArrayList<Car>(0);
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Query<Car> q = session.createQuery("from garaje", Car.class);
                salida = (ArrayList<Car>) q.getResultList();
            }


        return out;
    }



}
