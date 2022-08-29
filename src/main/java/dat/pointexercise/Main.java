package dat.pointexercise;

import dat.pointexercise.entities.Point;
import dat.pointexercise.facades.PointFacade;

import javax.persistence.*;
import java.util.*;

public class Main {

    private static PointFacade pointFacade;

    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        pointFacade = PointFacade.getInstance(emf);

        pointFacade.persistPoints(1000);

        System.out.println("Number of points: " + pointFacade.findNumberOfPoints());

        System.out.println("Average X: " + pointFacade.getAvg());

        List<Point> points = pointFacade.getAllPoints();
        System.out.println("All points: ");
        for (Point p : points)
        {
            System.out.print(p + " - ");
        }
        // Close the database connection:

        emf.close();
    }
}
