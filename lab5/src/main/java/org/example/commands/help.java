package org.example.commands;

import org.example.managers.CollectionManager;

import java.util.HashMap;
/**
 * Команда help - вывести справку по доступным командам
 *
 * @author Nazerke
 */
public class help extends Command{
    /**
     * Словарь команд
     */
    private final HashMap<String, Command> commands;
    /**
     * Конструктор класса help
     *
     * @param collectionManager менеджер коллекции
     * @param commands           словарь команд
     */
    public help(CollectionManager collectionManager, HashMap<String, Command> commands) {
        super("help","вывести справку по доступным командам", collectionManager);
        this.commands = commands;
    }
    /**
     * Вывести справку по доступным командам
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg){
        for (Command command : commands.values()) {
            System.out.println(command.getName() + " - '" + command.getDescription() + "'");
        }

    }
}
