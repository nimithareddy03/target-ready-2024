package question3;

public class Rectangle extends Shape {
    public double width = 1.0;
    public double length = 1.0;
    public Rectangle() {
        this.length = length;
        this.width = width;
    }
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public Rectangle(double length, double width, String color, boolean filled) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }
    public void setWidth(double width) {

        if(width < 0){
            throw new RuntimeException("Invalid width value");
        }
        this.width = width;
    }
    public double getWidth() {
        return width;
    }
    public void setLength(double length) {
        if(length < 0){
            throw new RuntimeException("Invalid length value");
        }
        this.length = length;
    }

    @Override
    public boolean isFilled() {
        return super.isFilled();
    }

    public double getLength() {
        return length;
    }
    public double getArea() {
        return length*width;
    }
    public double getPerimeter() {
        return 2*(length + width);
    }
    @Override
    public String toString(){
        String className = this.getClass().getName();
        String s1 = super.toString();
        return className + "A rectangle with width = " + getWidth() + "and length = "+ getLength() + " , which is subclass of " + s1;
    }
}
