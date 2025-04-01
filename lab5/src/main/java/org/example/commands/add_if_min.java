package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
import org.example.modules.FlatGenerator;
/**
 * Команда add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 *
 * @author Nazerke
 *
 */
public class add_if_min extends Command{
    /**
     * Менеджер коллекции
     */
    CollectionManager collectionManagers;

    /**
     * Конструктор класса Add_if_min
     *
     * @param collectionManager менеджер коллекции
     */
    public add_if_min(CollectionManager collectionManager) {
        super("add_if_min", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции", collectionManager);
        this.collectionManagers = collectionManager;
    }
    /**
     * Добавить новый элемент в коллекцию
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg) {
        Flat minFlat = new Flat();
        if (getCollectionManager().getCollection().size() == 1) {
            minFlat = getCollectionManager().getCollection().element();
        } else {
            for (Flat flat: getCollectionManager().getCollection()){
                for (Flat flat1: getCollectionManager().getCollection()){
                    if (flat.getArea() > flat1.getArea()){
                        minFlat = flat1;
                    }}
            }
        }
        Flat newFlat = FlatGenerator.generateFlat(collectionManagers);
        if (minFlat.getArea() > newFlat.getArea()){
            getCollectionManager().getCollection().add(newFlat);
            System.out.println("Flat was added to collection");
        } else {System.out.println("Flat was not added to collection");}
    }
}
