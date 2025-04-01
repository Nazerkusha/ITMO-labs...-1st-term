package org.example.system;

import org.example.managers.CommandManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    /**
     * Строка приглашения
     */
    private static final String prompt = "$ ";
    /**
     * Сканер для чтения из файла
     */
    private static Scanner fileScanner = null;
    private static final Scanner defScanner = new Scanner(System.in);
    /**
     * Менеджер команд
     */
    private final CommandManager commandManager = new CommandManager();
    /**
     * Пример консоли
     */
    private static Console instance = null;

    /**
     * Получение примера консоли
     * @return пример
     */
    public static Console getConsoleInstance() {
        if (instance == null) {
            instance = new Console();
        }
        return instance;
    }
    /**
     * Чтение строки из fileScanner, если он активен,
     * если не активен, то чтение строки из defScanner
     * @return возвращает следующую строку
     */
    public String readInput() throws IllegalStateException, NoSuchElementException {
        if (fileScanner != null) {
            //чтение строки из файла
            return fileScanner.nextLine();
        } else {
            //чтение строки из консоли
            return defScanner.nextLine();
        }
    }
    /**
     * Геттер для получения текущего prompt (приглашения)
     * @return prompt
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Строка для вывода объекта
     * @param obj объект
     */

    public void println(Object obj){
        System.out.println(obj);
    }
    /**
     * Переключает ввод на файл, ввод данных будет из переданного сканера
     * @param scanner сканер для чтения из файла
     */
    public void useFileScanner(Scanner scanner) {
        fileScanner = scanner;
    }

    /**
     * Переключает ввод на стандартный поток вывода (консоль)
     */
    public void useConsoleScanner() {
        fileScanner = null;
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(input);
            commandManager.execute(input);
        }
    }
    /**
     * Проверка, есть ли ещё строки для чтения
     * @return возвращает true, если ещё остались строки для чтения, иначе false
     */
    public boolean hasNextInput() {
        return (fileScanner != null) ? fileScanner.hasNextLine() : defScanner.hasNextLine();
    }
}
