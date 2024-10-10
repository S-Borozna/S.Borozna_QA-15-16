package Lesson_11;

public class Circle implements Figure {
    private double radius;
    private double perimetr;
    private double area;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatPerimet() {
        return perimetr = 2 * Math.PI * radius;
    }

    @Override
    public double calculatArea() {
        return area = Math.PI * radius * radius;
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

}
