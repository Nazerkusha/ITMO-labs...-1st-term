package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
/**
 * Команда print_ascending - вывести элементы коллекции в порядке возрастания
 *
 * @author Nazerke
 */

public class print_ascending extends Command {
    /**
     * Конструктор класса print_ascending
     *
     * @param collectionManager менеджер коллекции
     */
    public print_ascending(CollectionManager collectionManager) {
        super("print_ascending","вывести элементы коллекции в порядке возрастания", collectionManager);
    }
    /**
     * Вывести элементы коллекции в порядке возрастания
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        if (getCollectionManager().getCollection().isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            getCollectionManager().getCollection().stream()
                    .sorted(Flat::compareTo)
                    .forEach(System.out::println);
        }
    }
}
