package org.example.commands;

import org.example.managers.CollectionManager;
/**
 * Команда exit - завершить программу
 *
 * @author Nazerke
 */

public class exit extends Command{
    /**
     * Конструктор класса exit
     *
     * @param collectionManager менеджер коллекции
     */
    public exit(CollectionManager collectionManager) {
        super("exit","завершить программу", collectionManager);
    }
    /**
     * Завершить программу
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg) {
        System.out.println("Completion of the program");
        System.exit(0);
    }
}
