package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
import org.example.modules.FlatGenerator;

/**
 * Команда add - добавить новый элемент в коллекцию
 *
 * @author Nazerke
 */
public class add extends Command{
    /**
     * Менеджер коллекции
     */
    CollectionManager collectionManager;
    /**
     * Конструктор класса Add
     *
     * @param collectionManagers менеджер коллекции
     */
    public add(CollectionManager collectionManagers) {
        super("add","добавить новый элемент в коллекцию", collectionManagers);
        this.collectionManager = collectionManagers;
    }
    /**
     * Добавить новый элемент в коллекцию
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        Flat flat = FlatGenerator.generateFlat(collectionManager);
        getCollectionManager().getCollection().add(flat);
        System.out.println("Flats id is " + flat.getId() + "\nFlat was added to collection");
    }
}
