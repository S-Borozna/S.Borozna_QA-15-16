package Lesson_11;

public class Rectangle implements Figure {
    static int counter;
    int rectangelId;
    private double length;
    private double width;
    private double perimetr;
    private double area;
    private String fillColor;
    private String borderColor;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        counter += 1;
        rectangelId = counter;
    }

    @Override
    public void calculatPerimet() {
        perimetr = 2 * (length + width);
    }

    @Override
    public void calculatArea() {
        area = length * width;
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
        System.out.println("Прямоугольник: " + rectangelId + "  Периметр: " + perimetr + " Площадь: " + area +
                " Цвет заливки: " + fillColor + " Цвет границы: " + borderColor);
    }
}
