package dat.pointexercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "point")
public class Point
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "x")
    private int x;
    @Column(name="y")
    private int y;

    public Point()
    {
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }


}