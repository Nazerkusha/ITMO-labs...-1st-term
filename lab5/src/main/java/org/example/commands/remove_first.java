package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
/**
 * Команда remove_first - удалить первый элемент из коллекции
 *
 * @author Nazerke
 */
public class remove_first extends Command{
    /**
     * Конструктор класса remove_first
     *
     * @param collectionManager менеджер коллекции
     */

    public remove_first(CollectionManager collectionManager) {
        super("remove_first","удалить первый элемент из коллекции", collectionManager);
    }
    /**
     * Удалить первый элемент из коллекции
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg) {
        if (getCollectionManager().getCollection().isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            Flat flat = getCollectionManager().getFirst();
            getCollectionManager().getCollection().remove(flat);
            System.out.println("Element deleted");
        }
    }

}
