package org.example.modules;

/**
 * Значения типа транспорта
 *
 * @author Nazerke
 */
public enum Transport {
    FEW,
    NONE,
    LITTLE,
    NORMAL,
    ENOUGH;

    /**
     * Метод возвращающий типы транспортов
     * @return типы транспортов
     */

    public static String TransportTypeList() {
        StringBuilder transportType = new StringBuilder();
        for (Transport transport: Transport.values()) {
        transportType.append(transport.name()).append(", ");
    }
        return transportType.substring(0, transportType.length() - 2);
    }
}
