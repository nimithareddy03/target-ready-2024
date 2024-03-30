package day2.question1;

public class Cylinder extends Circle {
    private double height = 1.0;
    public Cylinder() { }
    public Cylinder(double radius) {
        super(radius);
    }
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        if(height < 0){
            throw new RuntimeException("Invalid Height");
        }
        this.height = height;
    }
    public double getVolume(){
        double radius = super.radius;
        return radius * radius * height * 3.14;
    }
}
