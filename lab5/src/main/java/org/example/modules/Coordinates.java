package org.example.modules;

import java.util.Objects;

/**
 * Модуль координат
 * @author Nazerke
 */
public class Coordinates {
    /**
     * Значение х
     */
    private final float x; //Значение поля должно быть больше -360
    /**
     * Значение y
     */
    private final Long y; //Значение поля должно быть больше -118, Поле не может быть null
    /**
     * Конструктор координат
     */
    public Coordinates(float x, Long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates that)) return false;
        return Float.compare(that.x, x) == 0 && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
