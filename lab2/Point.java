public class Point {
    public float x;
    public float y;
    public float z;

    Point(float X, float Y, float Z) {
        x = X;
        y = Y;
        z = Z;
    }
    public String toString() {
        return "("+x+","+y+","+z+")";
    }

    public boolean equals(Point a) {
        return (x== a.x && y==a.y && z == a.z)?true:false;
    }

    public void move(float dx, float dy, float dz){
        x+=dx;
        y+=dy;
        z+=dz;
    }
}
