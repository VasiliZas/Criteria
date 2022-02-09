package web.vasilizas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vasilizas.bean.db.Car;
import vasilizas.bean.db.Moto;
import web.vasilizas.repositories.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Start {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger("Start");
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        TypedQuery<String> query = em.createNamedQuery("bySport", String.class);
//        query.setParameter("sport", "cross");
//        query.getResultList().forEach(moto -> log.info("MOTO {}", moto));

        TypedQuery<Moto> query = em.createNamedQuery("byFuel", Moto.class);
        query.setParameter("fuel", 3);
        query.getResultList().forEach(moto -> log.info("MOTO {}", moto));

//        TypedQuery<Car> query = em.createQuery("select p from Car p ", Car.class);
//        query.getResultList().forEach(car -> log.info("Car {}", car));

//        TypedQuery<String> query = em.createQuery("select p.type from Car p ", String.class);
//       query.getResultList().forEach(car -> log.info("Car {}", car));

//        TypedQuery<String> query = em.createQuery("select (p.modelType) from Moto p where  p.fuel = 2", String.class);
//        query.getResultList().forEach(moto -> log.info("MOTO {}", moto));

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Car> query = cb.createQuery(Car.class);
//        Root<Car> root = query.from(Car.class);
//        ParameterExpression<String> nameExpression = cb.parameter(String.class, "modelType");
//        query.select(root).where(cb.like(root.get("modelType"), nameExpression));
//        em.createQuery(query).setParameter("modelType", "B%").getResultList().forEach(car -> log.info("Car {}", car));

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Moto> query = cb.createQuery(Moto.class);
//        Root<Moto> moto = query.from(Moto.class);
//        em.createQuery(query).getResultList().forEach(moto1 -> log.info("Moto {}",moto1));

        tx.commit();
        em.close();
    }
}
