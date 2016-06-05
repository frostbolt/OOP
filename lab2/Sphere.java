package com.company;
public class Sphere {
    Circle c;
    float radius;

    Sphere(Point C, float R) {
        c = new Circle(C, R);
        radius = R;
    }

    Sphere(Object a) {
        if (a.getClass().toString() == "class com.company.Sphere"){
            Sphere b = (Sphere) a;
            c = b.c;
            radius = b.radius;
        }
    }


    public String toString() {
        return "(x-"+c.center.x+")^2 + (y-"+c.center.y+")^2 + (z-"+c.center.z+")^2 <= "+radius*radius;
    }

    public boolean equals(Sphere a) {
        return (c == a.c && radius == a.radius)?true:false;
    }

    public double vol() {
        return 4/3*3.14159265*radius*radius*radius;
    }

    public double area() {
        return 4*3.14159265*radius*radius;
    }

    public void resize(float r) {
        if (r>0) {
            radius = r;
        }
    }
    public void move(float dx, float dy, float dz) {
        c.move(dx,dy,dz);
    }
}
