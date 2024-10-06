package Lesson_11;

public class Circle implements Figure {
    static int counter;
    int circelId;
    private double radius;
    private double perimetr;
    private double area;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
        counter += 1;
        circelId = counter;
    }

    @Override
    public void calculatPerimet() {
        perimetr = 2 * Math.PI * radius;
    }

    @Override
    public void calculatArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public void info() {
        System.out.println("Круг: " + circelId + " Периметр: " + perimetr + " Площадь: " + area + " Цвет заливки: " +
                fillColor + " Цвет границы: " + borderColor);
    }
}
