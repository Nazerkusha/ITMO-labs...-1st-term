package org.example.modules;

import java.util.Objects;

/**
 * Модуль Дом
 *
 * @author Nazerke
 */
public class House {
    private String name; //Поле не может быть null
    private int year; //Максимальное значение поля: 153, Значение поля должно быть больше 0
    private Long numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    /**
     * Конструктор дома
     */
    public House() {
    }

    /**
     * Установка имени
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Установка года
     * @param year год
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Установка количества квартир на этаже
     * @param numberOfFlatsOnFloor количество квартир на этаже
     */
    public void setNumberOfFlatsOnFloor(Long numberOfFlatsOnFloor) {
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        return year == house.year && Objects.equals(name, house.name) && Objects.equals(numberOfFlatsOnFloor, house.numberOfFlatsOnFloor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, numberOfFlatsOnFloor);
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfFlatsOnFloor=" + numberOfFlatsOnFloor +
                '}';
    }
}
