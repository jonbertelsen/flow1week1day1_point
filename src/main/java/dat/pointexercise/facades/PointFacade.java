package dat.pointexercise.facades;

import dat.pointexercise.entities.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class PointFacade
{
    private static PointFacade instance;
    private static EntityManagerFactory emf;

    private PointFacade()
    {}

    public static PointFacade getInstance(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new PointFacade();

        }
        return instance;
    }

    public void persistPoints(int numberOfPoints)
    {
        // Store 1000 Point objects in the database:
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < numberOfPoints; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
        em.close();
    }

    public long findNumberOfPoints()
    {
        // Find the number of Point objects in the database:
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        long result =  (long) q1.getSingleResult();
        em.close();
        return result;
    }

    public double getAvg()
    {
        // Find the average X value:
        EntityManager em = emf.createEntityManager();
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        double result = (double) q2.getSingleResult();
        em.close();
        return result;
    }

    public List<Point> getAllPoints()
    {
        // Retrieve all the Point objects from the database:
        EntityManager em = emf.createEntityManager();
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        em.close();
        return results;
    }
}
