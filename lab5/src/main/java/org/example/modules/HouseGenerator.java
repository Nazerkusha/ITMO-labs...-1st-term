package org.example.modules;

import java.util.Scanner;

/**
 * Генератор дома
 *
 * @author Nazerke
 */
public class HouseGenerator {
    /**
     * Метод для генерации дома
     * @return Дом
     */
    public static House generateHouse(){
        House house = new House();
        Scanner scanner = new Scanner(System.in);
        String HouseName;
        int year;
        long numberOfFlatsOnFloor;
        while (true) {
            try {
                System.out.println("Enter house information");
                System.out.println("Please enter name of the house: ");
                HouseName = scanner.nextLine();
                System.out.println("Please enter number of flats on floor: ");
                numberOfFlatsOnFloor = Long.parseLong(scanner.nextLine());
                System.out.println("Please enter year: ");
                year = Integer.parseInt(scanner.nextLine());
                if (HouseName.isEmpty() || 153 < year || year <= 0 || numberOfFlatsOnFloor <= 0) {
                    System.out.println("Number of flats on floor, name or year are out of range");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Number of flats on floor, name or year are not correct >:(");
                continue;
            }
            house.setName(HouseName);
            house.setYear(year);
            house.setNumberOfFlatsOnFloor(numberOfFlatsOnFloor);
            break;
        }
        return house;
    }
}
