package lab3;
public class Circle {
    Point center;
    float radius;

    Circle(Point C, float R) {
        center = C;
        radius = R;
    }

    public String toString() {
        return "Circle ("+center.x+","+center.y+","+center.z+")"+" Radius"+radius;
    }

    public boolean equals(Circle a) {
        return (center == a.center && radius == a.radius)?true:false;
    }

    public double area() {
        return 3.14159265*radius*radius;
    }

    public void move(float dx, float dy, float dz) {
        center.move(dx,dy,dz);
    }
}
