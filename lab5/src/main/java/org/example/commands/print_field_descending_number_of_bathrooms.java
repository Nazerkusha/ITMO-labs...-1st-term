package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.modules.FlatComparatorByNOBR;
/**
 * Команда print_field_descending_number_of_bathrooms - вывести значения поля numberOfBathrooms всех элементов в порядке убывания
 *
 * @author Nazerke
 */
public class print_field_descending_number_of_bathrooms extends Command{
    /**
     * Конструктор класса print_field_descending_number_of_bathrooms
     *
     * @param collectionManager менеджер коллекции
     */
    public print_field_descending_number_of_bathrooms(CollectionManager collectionManager) {
        super("print_descending_numberOfBathrooms","вывести значения поля numberOfBathrooms всех элементов в порядке убывания", collectionManager);
    }
    /**
     * Вывести значения поля numberOfBathrooms всех элементов в порядке убывания
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        if (getCollectionManager().getCollection().isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            FlatComparatorByNOBR comparatorByBathrooms = new FlatComparatorByNOBR();
            getCollectionManager().getCollection().stream()
                    .sorted(comparatorByBathrooms)
                    .forEach(flat -> {
                        System.out.println(flat.getNumberOfBathrooms());
                    });
        }

    }


}
