package org.example.managers;

import org.example.commands.*;


import java.util.HashMap;

/**
 * Менеджер команд
 *
 * @author Nazerke
 */

public class CommandManager {
    /**
     * Список команд
     */
    private final HashMap<String, Command> commands = new HashMap<>();

    /**
     * Получения списка команд
     * @return список команды
     */

    public HashMap<String, Command> getCommands() {
        return commands;
    }
    /**
     * Имя файла
     */
    String Filename = "1.txt";
    /**
     * Мусорный менеджер
     */
    DumpManager dumpManager = new DumpManager(Filename);
    /**
     * Менеджер коллекции
     */
    CollectionManager collectionManager = new CollectionManager(dumpManager);

    /**
     * Конструктор менеджера команд
     */
    public CommandManager(){
        commands.put("info", new info(collectionManager));
        commands.put("show", new show(collectionManager));
        commands.put("add", new add(collectionManager));
        commands.put("print_ascending", new print_ascending(collectionManager));
        commands.put("exit", new exit(collectionManager));
        commands.put("help", new help(collectionManager, commands));
        commands.put("clear", new clear(collectionManager));
        commands.put("add_if_min", new add_if_min(collectionManager));
        commands.put("head", new head(collectionManager));
        commands.put("remove_first", new remove_first(collectionManager));
        commands.put("print_descending_numberOfBathrooms", new print_field_descending_number_of_bathrooms(collectionManager));
        commands.put("print_unique_house", new print_unique_house(collectionManager));
        commands.put("remove_by_id", new remove_by_id(collectionManager));
        commands.put("update_id", new update_id(collectionManager));
        commands.put("save", new save(collectionManager));
        commands.put("execute_script", new execute_script(collectionManager, commands));

    }

    /**
     * Метод выполнения команды
     * @param input введённый объект
     */

    public void execute(String input){
        String command = input.split(" ")[0];
        if (commands.containsKey(command)) {
            try {
                commands.get(command).execute(input.split(" ")[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                commands.get(command).execute(null);
            }
        } else { System.out.println("Theres no command like this " + command);
        }
    }
}

