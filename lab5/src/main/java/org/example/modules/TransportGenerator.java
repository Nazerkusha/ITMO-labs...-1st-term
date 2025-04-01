package org.example.modules;

import java.util.Scanner;

/**
 * Генератор транспорта
 *
 * @author Nazerke
 */
public class TransportGenerator {
    /**
     * Метод генерации транспорта
     * @return Транспорт
     */
    public static Transport generateTransport(){
        Transport transport;
        Scanner scanner = new Scanner(System.in);
        String transportType;
        while (true) {
            try {
                System.out.println("Please enter type of transport: ");
                transportType = scanner.nextLine();
                transport = Transport.valueOf(transportType);
            } catch (Exception e) {
                System.out.println("Transport definition is wrong");
                continue;
            }
            break;
        }
        return transport;
    }
}
