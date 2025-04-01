package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
import org.example.modules.FlatGenerator;
/**
 * Команда update_id - обновить значение элемента коллекции, id которого равен заданному
 *
 * @author Nazerke
 */

public class update_id extends Command{
    /**
     * Менеджер коллекции
     */
    CollectionManager collectionManager;
    /**
     * Конструктор класса update_id
     *
     * @param collectionManagers менеджер коллекции
     */
    public update_id(CollectionManager collectionManagers) {
        super("update_id","обновить значение элемента коллекции, id которого равен заданному", collectionManagers);
        this.collectionManager = collectionManagers;
    }
    /**
     * Обновить значение элемента коллекции, id которого равен заданному
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
                Flat UpdFlat = FlatGenerator.generateFlat(collectionManager);
                UpdFlat.setId(id);
                getCollectionManager().getCollection().add(UpdFlat);
                System.out.println("Flats id is " + flat.getId() +"\nFlat was updated");
            }
        } catch (Exception e){
            System.out.println("Wrong Id");
        }
    }

}
