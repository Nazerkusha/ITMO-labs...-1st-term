package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.Flat;
import org.example.modules.House;

import java.util.HashSet;
/**
 * Команда print_unique_house - вывести уникальные значения поля house всех элементов в коллекции
 *
 * @author Nazerke
 */

public class print_unique_house extends Command{
    /**
     * Конструктор класса print_unique_house
     *
     * @param collectionManager менеджер коллекции
     */
    public print_unique_house(CollectionManager collectionManager) {
        super("print_unique_house","вывести уникальные значения поля house всех элементов в коллекции", collectionManager);
    }
    /**
     * Вывести уникальные значения поля house всех элементов в коллекции
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
            var set = new HashSet<House>();
            int Null = 0;
            Flat flat = new Flat();
            for (var e : getCollectionManager().getCollection()) {
                if (e.getHouse() == null && Null == 0){
                    set.add(e.getHouse());
                    Null = Null+1;
                }
                else if (e.getHouse() == null){
                    set.remove(e.getHouse());
                }
                else if (!(e.getHouse().equals(flat.getHouse()))) {
                    set.add(e.getHouse());
                } else {
                    set.remove(e.getHouse());
                    set.remove(flat.getHouse());
                }
                flat = e;
            }
            if (set.isEmpty())
                System.out.println("There is no unique house");
            else for (var e : set)
                System.out.println(e);
    }
}
