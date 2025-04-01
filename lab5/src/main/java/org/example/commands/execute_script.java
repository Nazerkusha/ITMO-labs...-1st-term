package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.ScriptManager;

import java.util.HashMap;

/**
 * Команда execute_script - считать и исполнить скрипт из указанного файла.
 *
 * @author Nazerke
 */

public class execute_script extends Command{
    /**
     * Словарь команд
     */
    private final HashMap<String, Command> commands;
    /**
     * Конструктор класса execute_script
     *
     * @param collectionManagers менеджер коллекции
     * @param commands           словарь команд
     */
    public execute_script(CollectionManager collectionManagers, HashMap<String, Command> commands) {
        super("execute_script","считать и исполнить скрипт из указанного файла.", collectionManagers);
        this.commands = commands;
    }
    /**
     * Исполнить скрипт из указанного файла
     *
     * @param arg вводимая в консоль строка
     */
    @Override
    public void execute(String arg) {
        if (arg==null){
            System.out.println("Error, enter command with script name, please!");
        } else {
            ScriptManager scriptManager = new ScriptManager();
            System.out.println("Script execution '" + arg + "'...");
            scriptManager.executeScript(arg, commands);
        }

    }
}
