package question3;


public class Program {
    public static void main(String[] args) {
        Shape[] s = { new Circle(),
                new Circle(2),
                new Circle(2,"blue", false),
                new Rectangle(),
                new Rectangle(4, 3),
                new Rectangle(9,4,"black",true),
                new Square(),
                new Square(5),
                new Square(5,"green",true),
                new Rectangle(4,9)};

        for(int i = 0; i< 10; i++) {
            if(s[i] instanceof Circle) {
                Circle c1 = (Circle) s[i];
                System.out.println(c1.getArea());
                System.out.println(c1.getPerimeter());
                System.out.println(c1.toString());
                System.out.println();
            }
            if(s[i] instanceof Rectangle) {
                Rectangle r1 = (Rectangle) s[i];
                System.out.println(r1.getArea());
                System.out.println(r1.getPerimeter());
                System.out.println(r1.toString());
                System.out.println();
            }
            if(s[i] instanceof Square) {
                Square sq1 = (Square) s[i];
                System.out.println(sq1.getArea());
                System.out.println(sq1.getPerimeter());
                System.out.println(sq1.toString());
                System.out.println();
            }
        }
    }
}
