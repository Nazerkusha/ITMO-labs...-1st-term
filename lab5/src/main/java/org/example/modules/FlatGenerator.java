package org.example.modules;

import java.time.ZonedDateTime;
import java.util.Scanner;

import org.example.managers.CollectionManager;

import static org.example.modules.HouseGenerator.generateHouse;
import static org.example.modules.TransportGenerator.generateTransport;

/**
 * Генератор элемента Квартиры
 *
 * @author Nazerke
 */
public class FlatGenerator {
    /**
     * Метод генерации квартиры
     * @param collectionManager менеджер коллекции
     * @return квартира
     */
    public static Flat generateFlat(CollectionManager collectionManager) {
        Flat flat = new Flat();
        Scanner scanner = new Scanner(System.in);
        String name;
        ZonedDateTime creationDate = ZonedDateTime.now();
        double area;
        long numberOfBathrooms;
        int numberOfRooms;
        float x;
        Long y;
        flat.setCreationDate(creationDate);
        long newId = collectionManager.generateNewId();
        flat.setId(newId);
        while (true) {
            System.out.println("Please enter your name: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name is not correct >:(");
                continue;
            }
            flat.setName(name);
            break;
        }
        while (true) {
            try {
                System.out.println("Please enter area: ");
                area = Double.parseDouble(scanner.nextLine());
                if (area > 539 || area <= 0) {
                    System.out.println("Area is out of range");
                    continue;
                }
                flat.setArea(area);
            } catch (Exception e) {
                System.out.println("Area is not correct >:(");
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Please enter number of bathrooms: ");
                numberOfBathrooms = Long.parseLong(scanner.nextLine());
                if (numberOfBathrooms <= 0) {
                    System.out.println("Number of bathrooms is out of range");
                    continue;
                }
                flat.setNumberOfBathrooms(numberOfBathrooms);
            } catch (Exception e) {
                System.out.println("Number of bathrooms is not correct >:(");
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Please enter number of rooms: ");
                numberOfRooms = Integer.parseInt(scanner.nextLine());
                if (numberOfRooms <= 0 || numberOfRooms > 14) {
                    System.out.println("Number of rooms is out of range");
                    continue;
                }
                flat.setNumberOfRooms(numberOfRooms);
            } catch (Exception e) {
                System.out.println("Number of rooms is not correct >:(");
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Please enter X: ");
                x = Float.parseFloat(scanner.nextLine());
                System.out.println("Please enter Y: ");
                y = Long.valueOf(scanner.nextLine());
                if (x <= -360 || y <= -118 || y == null) {
                    System.out.println("Coordinates are out of range");
                    continue;
                }
                Coordinates coordinates = new Coordinates(x, y);
                flat.setCoordinates(coordinates);
            } catch (Exception e) {
                System.out.println("Coordinates are not correct >:(");
                continue;
            }
            break;
        }
        System.out.println("Creating house");
        if (scanner.nextLine().isEmpty()) {
            flat.setHouse(null);
        } else { House house = generateHouse();
            flat.setHouse(house); }
        System.out.println("Adding transport");
        if (scanner.nextLine().isEmpty()) {
            flat.setTransport(null);
        } else { Transport transport = generateTransport();
            flat.setTransport(transport); }
        return flat;
    }

}
