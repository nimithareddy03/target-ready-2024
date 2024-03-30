package day2.question1;

public class Circle {
    public double radius = 1.0;
    public String color = "red";
    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius) {
        if(radius < 0){
            throw new RuntimeException("Invalid radius.");
        }
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return 3.14 * radius * radius;
    }
    public String toString(){
        return "Circle [ radius = " + radius +" , color = " + color +" ]";
    }
}
