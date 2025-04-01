package org.example.commands;

import org.example.managers.CollectionManager;
/**
 * Команда head - вывести первый элемент коллекции
 *
 * @author Nazerke
 */

public class head extends Command{
    /**
     * Конструктор класса Head
     *
     * @param collectionManager менеджер коллекции
     */
    public head(CollectionManager collectionManager) {
        super("head","вывести первый элемент коллекции", collectionManager);
    }
    /**
     * Вывести первый элемент коллекции
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        try{
            if (getCollectionManager().getCollection().isEmpty()) {
                System.out.println("Collection is empty");
            } else {
                System.out.println("First element in collection: " + "\n" + getCollectionManager().getFirst());
            }
        } catch(Exception e){
            System.out.println("Something is wrong");
        }
    }
}

