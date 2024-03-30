package question3;

public class Square extends Rectangle {
    public double side;
    public Square(){}
    public Square(double side) {
        this.length = side;
        this.width = side;
    }
    public Square(double side, String color, boolean filled){
        super(side, side,color, filled);
    }
    public double getSide() {
        return length;
    }
    @Override

    public void setWidth(double side){
        if(side < 0){
            throw new RuntimeException("Invalid side value");
        }
        super.width = side;
    }
    public void setLength(double side) {
        if (side < 0) {
            throw new RuntimeException("Invalid side value");
        }
        super.length = side;
    }
    @Override
    public String toString(){
        String className = this.getClass().getName();
        String s1 = super.toString();
        return className + "A Square with side = " + getSide() + " , which is subclass of " + s1;
    }

}
