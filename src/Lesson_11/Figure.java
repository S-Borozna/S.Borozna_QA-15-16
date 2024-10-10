package Lesson_11;

public interface Figure {

    double calculatPerimet();

    double calculatArea();

    void setFillColor(String color);

    String getFillColor();

    void setBorderColor(String color);

    String getBorderColor();

    default void info() {
        System.out.println("Периметр: " + calculatPerimet() + " Площадь: " + calculatArea() +
                " Цвет заливки: " + getFillColor() + " Цвет границы: " + getBorderColor());
    }
}
