package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
/**
 * Команда remove_by_id - удалить элемент из коллекции по его id
 *
 * @author Nazerke
 */
public class remove_by_id extends Command {
    /**
     * Конструктор класса remove_by_id
     *
     * @param collectionManagers менеджер коллекции
     */
    public remove_by_id(CollectionManager collectionManagers) {
        super("remove_by_id","удалить элемент из коллекции по его id", collectionManagers);
    }
    /**
     * Удалить элемент из коллекции по его id
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        try {
            long id = Long.parseLong(arg);
            Flat flat = getCollectionManager().getFlatById(id);
            if (arg.isEmpty() || flat == null){
                System.out.println("There is no flat with such id");
            } else {
                getCollectionManager().remove(id);
                System.out.println("Flat was removed");
            }
        } catch (Exception e){
            System.out.println("Wrong Id");
        }
    }
}
