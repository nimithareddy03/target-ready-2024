package question3;

public class Circle extends Shape {
    public double radius = 1.0;
    public Circle(){
        super();
        this.radius = radius;

    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    public void setRadius(double radius){

        if(radius < 0){
            throw new RuntimeException("Invalid radius value");
        }
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return 3.14*radius*radius;
    }
    public double getPerimeter(){
        return 2*3.14*radius;
    }
    @Override
    public String toString(){
        String className = this.getClass().getName();
        String s1 = super.toString();
        return className + "A circle with radius = " + getRadius() + " , which is subclass of " + s1;
    }
}