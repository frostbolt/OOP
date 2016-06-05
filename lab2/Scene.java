package com.company;
public class Scene {
    int size;
    int maxSize;
    Object[] array;
    Point dimension; // самая отдаленная точка (сцена -- параллелепипед). Координаты объектов -- относительно сцены.
    Point placement; // Положение сцены в пространстве.

    Scene(int sz) {
        this(sz,sz, null, new Point(50,50,50),new Point());
    }

    Scene(int sz, int maxSz) {
        this(sz, maxSz, null, new Point(50,50,50),new Point());
    }

    Scene(int sz, int maxSz, Object[] iniArray, Point D, Point P) {
        size = sz;
        maxSize = (maxSz<sz?sz:maxSz);
        array = new Object[maxSize];
        if (iniArray != null) {
            for (int i=0; i < size && i < iniArray.length; i++){
                array[i] = iniArray[i];
            }
        }
    }

    public Object el_a(int i) {
        return array[i];
    }

    public void resize(int delta) {
        if (delta > 0) enlarge(delta);
        else if (delta <0) shrink(-delta);
    }

    private void enlarge(int delta) {
        if((size+=delta) > maxSize) {
            maxSize = size;
            Object[] newArray = new Object[maxSize];
            for (int i=0; i < size - delta; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    private void shrink(int delta) {
        size = (delta > size ? 0 : size - delta);
    }

    boolean add(Object e){
        resize(1);
        array[size-1]=e;
        if (!this.moveFigure(size-1,0,0,0)){
            this.shrink(1);
            return false;
        }
        return true;
    }

    public boolean equals(Scene a) {
        if (size == a.size && dimension == a.dimension){
            for (int i=0; i<size;i++) {
                if (array[i]!=a.array[i]) {
                    return false;
                }
            }
        }   else {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Положение в пространстве: "+placement+"\n"+"Размерность: "+dimension;
    }

    public boolean includes(Point a) {
        return (a.x<=dimension.x && a.y <= dimension.y && a.z <= dimension.z && a.x>0 && a.y > 0 && a.z > 0);
    }

    public boolean includes(Circle a){

        Point plusX = new Point(a.center);
        plusX.move(dimension.x, 0,0);
        Point minusX = new Point(a.center);
        minusX.move(-dimension.x, 0,0);

        Point plusY = new Point(a.center);
        plusY.move(0, dimension.y,0);
        Point minusY = new Point(a.center);
        minusY.move(0, -dimension.y,0);

        return (this.includes(a.center) && this.includes(plusX) && this.includes(minusX) && this.includes(plusY) && this.includes(minusY));
    }

    public boolean includes(Sphere a) {
        Point plusZ = new Point(a.c.center);
        plusZ.move(0, 0,dimension.z);
        Point minusZ = new Point(a.c.center);
        minusZ.move(0, 0,-dimension.z);
        return (this.includes(a.c) && this.includes(plusZ) && this.includes(minusZ));
    }

    public boolean includes(Cylinder a) {
        Point plusZ = new Point(a.c.center);
        plusZ.move(0, 0,dimension.z);

        return (this.includes(a.c) && this.includes(plusZ));
    }

    public boolean includes(Cone a) {
        Point plusZ = new Point(a.c.center);
        plusZ.move(0, 0,dimension.z);

        return (this.includes(a.c) && this.includes(plusZ));
    }

    public void move(float d1, float d2, float d3) {
        placement.move(d1,d2,d3);
    }

    public boolean moveFigure(int index, float d1, float d2, float d3){ // костыль

        if (array[index].getClass().toString() == "class com.company.Cone"){
            Cone a = new Cone(array[index]);
            a.move(d1,d2,d3);
            if (this.includes(a)){
                array[index] = a;
                return true;
            }
            return false;
        } else if (array[index].getClass().toString() == "class com.company.Sphere"){
            Sphere a = new Sphere(array[index]);
            a.move(d1,d2,d3);
            if (this.includes(a)){
                array[index] = a;
                return true;
            }
            return false;
        } else if (array[index].getClass().toString() == "class com.company.Cylinder"){
            Cylinder a = new Cylinder(array[index]);
            a.move(d1,d2,d3);
            if (this.includes(a)){
                array[index] = a;
                return true;
            }
            return false;
        }

        return false;
    }

    boolean changeSizeOfScene(Point p) {
        Point old = dimension;
        dimension = p;
        for (int i =0; i<size; i++) {
            if (!this.moveFigure(i,0,0,0)) {
                dimension = old;
                return false;
            }
        }
        return true;
    }

    public float SummaryArea(){
        float sum = 0;
        for (int i=0; i<size;i++) {
            if (array[i].getClass().toString() == "class com.company.Cone"){
                Cone temp = (Cone) array[i];
                sum+=temp.area();
            } else if (array[i].getClass().toString() == "class com.company.Sphere"){
                Sphere temp = (Sphere) array[i];
                sum+=temp.area();
            } else if (array[i].getClass().toString() == "class com.company.Cylinder") {
                Cylinder temp = (Cylinder) array[i];
                sum+=temp.area();
            }
        }
        return sum;
    }

    public float SummaryVol(){
        float sum = 0;
        for (int i=0; i<size;i++) {
            if (array[i].getClass().toString() == "class com.company.Cone"){
                Cone temp = (Cone) array[i];
                sum+=temp.vol();
            } else if (array[i].getClass().toString() == "class com.company.Sphere"){
                Sphere temp = (Sphere) array[i];
                sum+=temp.vol();
            } else if (array[i].getClass().toString() == "class com.company.Cylinder") {
                Cylinder temp = (Cylinder) array[i];
                sum+=temp.vol();
            }
        }
        return sum;
    }
}
