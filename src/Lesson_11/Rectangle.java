package Lesson_11;

public class Rectangle implements Figure {
    private double length;
    private double width;
    private double perimetr;
    private double area;
    private String fillColor;
    private String borderColor;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculatPerimet() {
        return perimetr = 2 * (length + width);
    }

    @Override
    public double calculatArea() {
        return area = length * width;
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
