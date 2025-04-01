package org.example.commands;

import org.example.managers.CollectionManager;

/**
 * Команда clear - очищает коллекцию
 *
 * @author Nazerke
 */

public class clear extends Command{

    /**
     * Конструктор класса Clear
     *
     * @param collectionManager менеджер коллекции
     */
    public clear(CollectionManager collectionManager) {
        super("clear","очистить коллекцию", collectionManager);
    }
    /**
     * Очищает коллекцию
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg) {
        getCollectionManager().getCollection().clear();
        System.out.println("Collection cleared");
    }
}
