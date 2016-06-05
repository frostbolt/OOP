package com.company;
public class Cone {

    Circle c;
    float height;

    Cone(Point C, float R, float H) {
        c = new Circle(C, R);
        height = H;
    }

    Cone(Circle C, float H) {
        c=C;
        height = H;
    }

    Cone(Object a) {
        if (a.getClass().toString() == "class com.company.Cone"){
            Cone b = (Cone) a;
            c = b.c;
            height = b.height;
        }
    }

    public String toString() {
        return "(x-"+c.center.x+")^2 + (y-"+c.center.y+")^2 <= "+c.radius*c.radius+",\n"+ //как описать?
                "z >= 0.";
    }

    public boolean equals(Cone a) {
        return (c == a.c && height == a.height)?true:false;
    }

    public double vol() {
        return 3.14159265*c.radius*c.radius*height/3;
    }

    public double area() {
        return 3.14159265*c.radius*(height+c.radius);
    }

    public void resize(float r, float h) {
        c.radius *= r;
        height *= h;
    }

    public void move(float dx, float dy, float dz) {
        c.move(dx,dy,dz);
    }
}
