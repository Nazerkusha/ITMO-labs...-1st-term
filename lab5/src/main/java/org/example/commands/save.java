package org.example.commands;

import org.example.managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда save - сохранить коллекцию в файл
 *
 * @author Nazerke
 */
public class save extends Command{
    /**
     * Менеджер коллекции
     */
    CollectionManager collectionManager;
    /**
     * Конструктор класса save
     *
     * @param collectionManagers менеджер коллекции
     */
    public save(CollectionManager collectionManagers) {
        super("save","сохранить коллекцию в файл", collectionManagers);
        this.collectionManager = collectionManagers;
    }
    /**
     * Сохранить коллекцию в файл
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter FileName: ");
            String filename = scanner.nextLine();
            collectionManager.saveCollection(filename);
        }catch(Exception e) {
            System.out.println("Saving error");
        }
    }
}
