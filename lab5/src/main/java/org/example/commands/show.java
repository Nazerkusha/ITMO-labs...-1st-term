package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
/**
 * Команда show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 *
 * @author Nazerke
 */
public class show extends Command{
    /**
     * Конструктор класса show
     *
     * @param collectionManager менеджер коллекции
     */
    public show(CollectionManager collectionManager) {
        super("show","вывести в стандартный поток вывода все элементы коллекции в строковом представлении", collectionManager);
    }
    /**
     * Вывести в стандартный поток вывода все элементы коллекции в строковом представлении
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        for (Flat flat: getCollectionManager().getCollection()){
            System.out.println(flat);
        }
    }

}
