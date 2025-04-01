package org.example.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;

import org.example.commands.Command;
import org.example.system.Console;


/**
 * Класс, который управляет скриптом
 *
 * @author Nazerke
 */
public class ScriptManager {
    private final Console console;
    private static Scanner fileScanner = null;
    /**
     * Конструктор класса ScriptManager
     */
    public ScriptManager() {
        this.console = Console.getConsoleInstance();
    }

    private int lengthRecursion = -1;
    private final Deque<String> scriptStack = new ArrayDeque<>(); //стек выполняемых скриптов

    /**
     * Проверяет рекурсивность выполнения скрипта
     * @param argument название скрипта, который запускается
     * @param scriptScanner сканер для чтения из скрипта
     * @return true, если может быть рекурсия, иначе false
     */
    private boolean checkRecursion(String argument, Scanner scriptScanner) {
        var recStart = -1;
        var i = 0;
        for (String script : scriptStack) {
            i++;
            if (argument.equals(script)) {
                if (recStart < 0) recStart = i;
                if (lengthRecursion < 0) {
                    fileScanner = null;
                    console.useConsoleScanner();
                    System.out.println("Была замечена рекурсия! Введите максимальную глубину рекурсии (0..300)");
                    while (lengthRecursion < 0 || lengthRecursion > 300) {
                        try {
                            System.out.println("> ");
                            lengthRecursion = Integer.parseInt(console.readInput().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Длина не распознана");
                        }
                    }

                    console.useFileScanner(scriptScanner);
                }
                if (i > recStart + lengthRecursion || i > 300)
                    return false;
            }
        }
        return true;
    }

    /** Метод для выполнения скрипта
     * @param fileName название файла со скриптом
     * @return результат выполнения скрипта
     */
    public void executeScript(String fileName, HashMap<String, Command> commands) {

        Path path = Paths.get(fileName);
        if (!path.isAbsolute()) {
            path = Paths.get(System.getProperty("user.dir"), fileName);
        }
        File scriptFile = path.toFile();
        if (!scriptFile.exists()) {
            System.out.println(false +"Файла нет: " + path.toAbsolutePath());
        }
        if (!scriptFile.canRead()) {
            System.out.println(false + "Нет прав на чтение файла: " + path.toAbsolutePath());
        }
        scriptStack.addLast(fileName);
        System.out.println("Файл найден, начинается выполнение скрипта ...");

        try (Scanner scannerForScript = new Scanner(scriptFile)) {
            if (!scannerForScript.hasNext()) throw new NoSuchElementException("Файл пустой!");
            console.useFileScanner(scannerForScript);
            String[] userCommand;

            do {
                userCommand = (console.readInput().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                //выводим команду с приглашением
                console.println(console.getPrompt() + String.join(" ", userCommand));
                if (commands.containsKey(userCommand[0])) {
                    try {
                        commands.get(userCommand[0]).execute(userCommand[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        commands.get(userCommand[0]).execute(null);
                    }
                } else { System.out.println("Theres no command like this " + userCommand[0]);
                }

                boolean isLaunchNeeded = true;
                if (userCommand[0].equals("execute_script")) {
                    isLaunchNeeded = checkRecursion(userCommand[1], scannerForScript);
                }

            } while (console.hasNextInput() && !userCommand[0].equals("exit"));
            //снова чтение из консоли
            console.useConsoleScanner();
            System.out.println("");

        } catch (FileNotFoundException e) {
            System.out.println(false + "Файл не найден: " + path.toAbsolutePath());
        } catch (NoSuchElementException e) {
            System.out.println(false + "Файл пустой: " + path.toAbsolutePath());
        } catch (Exception e) {
            System.out.println(false + "Ошибка выполнения скрипта " + e.getMessage());
        } finally {
            scriptStack.pollLast();
        }
    }
}