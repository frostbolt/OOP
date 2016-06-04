package com.company;

public class Cylinder {

    private Circle c;
    private float height;

    Cylinder(Point C, float R, float H) {
        c = new Circle(C, R);
        height = H;
    }

    Cylinder(Circle C, float H) {
        c=C;
        height = H;
    }
    public String toString() {
        return "(x-"+c.center.x+")^2 + (y-"+c.center.y+")^2 <= "+c.radius*c.radius+",\n"+c.center.z+"<= z <= "+ height +".";
    }

    public boolean equals(Cylinder a) {
        return (c == a.c && height == a.height)?true:false;
    }

    public double vol() {
        return 3.14159265*c.radius*c.radius*height;
    }

    public double area() {
        return 2*3.14159265*c.radius*(height+c.radius);
    }

    public void resize(float r, float h) {
        c.radius *= r;
        height *= h;
    }
    public void move(float dx, float dy, float dz) {
        c.move(dx,dy,dz);
    }
}
