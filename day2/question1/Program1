package day2.question1;

public class Program1 {
    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0,
                        "blue")
        };
        for(int i = 0; i < circles.length;i++) {
            double ca = circles[i].getArea();
            Cylinder c1 = (Cylinder) circles[i];
            double cv = c1.getVolume();
            System.out.printf("Circle %d area: %.2f\n", i + 1, ca);
            System.out.printf("Cylinder%d volume: %.2f\n\n", i + 1, cv);
        }
    }
}
