package lab3;
public class Sphere {
    Circle c;

    Sphere(Point C, float R) {
        c = new Circle(C, R);
    }

    
    Sphere(Circle a) {
    	c = a;
    }

    Sphere(Sphere a) {
    	c = a.c;
    }
    

    public String toString() {
        return "(x-"+c.center.x+")^2 + (y-"+c.center.y+")^2 + (z-"+c.center.z+")^2 <= "+c.radius*c.radius;
    }

    public boolean equals(Sphere a) {
        return (c == a.c && c.radius == a.c.radius)?true:false;
    }

    public double vol() {
        return 4/3*3.14159265*c.radius*c.radius*c.radius;
    }

    public double area() {
        return 4*3.14159265*c.radius*c.radius;
    }

    public void resize(float r) {
        if (r>0) {
        	c.radius = r;
        }
    }
    public void move(float dx, float dy, float dz) {
        c.move(dx,dy,dz);
    }
}
