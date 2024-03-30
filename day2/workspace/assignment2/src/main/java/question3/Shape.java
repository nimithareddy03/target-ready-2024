package question3;

public class Shape{
    public String color = "red";
    public boolean filled = true;
    public Shape(){
        this.color = color;
        this.filled = filled;
    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String getColor(){
        return color;
    }
    public boolean isFilled(){
        return  filled;
    }

    @Override
    public String toString(){
        String className = this.getClass().getName();
        String s1;
        if(isFilled()){
            s1 = "filled";
        }
        else {
            s1 = "not filled";
        }
        return className + " a shape with color of " + getColor() + " and " + s1;
    }

}
