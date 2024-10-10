package Lesson_11;

public class Triangle implements Figure {
    static int counter;
    int triangleId;
    private double side1;
    private double side2;
    private double side3;
    private double perimetr;
    private double area;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        counter += 1;
        triangleId = counter;
    }

    @Override
    public void calculatPerimet() {
        perimetr = side1 + side2 + side3;
    }

    @Override
    public void calculatArea() {
        double p = (side1 + side2 + side3) / 2;
        area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public void setFillColor(String color) {
        fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    @Override
    public void info() {
        System.out.println("Треугольник: " + triangleId + "   Периметр: " + perimetr + " Площадь: " + area +
                " Цвет заливки: " + fillColor + " Цвет границы: " + borderColor);
    }
}
