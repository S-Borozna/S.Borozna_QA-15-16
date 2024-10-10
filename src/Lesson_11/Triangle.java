package Lesson_11;

public class Triangle implements Figure {
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
    }

    @Override
    public double calculatPerimet() {
        return perimetr = side1 + side2 + side3;
    }

    @Override
    public double calculatArea() {
        double p = (side1 + side2 + side3) / 2;
        return area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public void setFillColor(String color) {
        fillColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }


}
