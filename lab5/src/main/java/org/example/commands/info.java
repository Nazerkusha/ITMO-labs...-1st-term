package org.example.commands;

import org.example.managers.CollectionManager;
/**
 * Команда info - вывести в стандартный поток вывода информацию о коллекции
 *
 * @author Nazerke
 */
public class info extends Command{
    /**
     * Конструктор класса info
     *
     * @param collectionManager менеджер коллекции
     */
    public info(CollectionManager collectionManager){
        super("info", "вывести в стандартный поток вывода информацию о коллекции", collectionManager);
    }
    /**
     * Вывести в стандартный поток вывода информацию о коллекции
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        System.out.println("Collection type: " + super.getCollectionManager().getCollection().getClass().getName());
        System.out.println("Elements of collection: " + super.getCollectionManager().getCollection().size());

    }
}
