package org.example.managers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.modules.Flat;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Мусорный менеджер
 */

public class DumpManager {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
            .create();
    /**
     * Имя файла
     */
    private String fileName;

    /**
     * Установка имени файла
     *
     * @param fileName имя файла
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Конструктор мусорного менеджера
     *
     * @param fileName имя файла
     */
    public DumpManager(String fileName) {
        if (!(new File(fileName).exists())) {
            fileName = "../" + fileName;
        }
        this.fileName = fileName;
    }

    /**
     * Записывает коллекцию в файл
     * @param collection коллекция
     */
    public void writeCollection(Collection<Flat> collection) {

        try (BufferedWriter collectionBufferWriter = new BufferedWriter(new FileWriter(fileName))) {
            collectionBufferWriter.write(gson.toJson(collection));
            System.out.println("Collection was saved");
        } catch (IOException exception) {
            System.out.println("The download file cannot be opened!");
        }
    }

    /**
     * Считывает коллекцию из файла
     * @return Считанная коллекция
     */
    public Collection<Flat> readCollection() {
        if (fileName != null && !fileName.isEmpty()) {
            try (var fileReader = new FileReader(fileName)) {
                var collectionType = new TypeToken<PriorityQueue<Flat>>() {}.getType();
                var reader = new BufferedReader(fileReader);
                var jsonString = new StringBuilder();

                String line;
                while((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.equals("")) {
                        jsonString.append(line);
                    }
                }
                if (jsonString.length() == 0) {
                    jsonString = new StringBuilder("[]");
                }
                PriorityQueue<Flat> collection = gson.fromJson(jsonString.toString(), collectionType);
                System.out.println("The collection has been successfully uploaded!");
                return collection;

            } catch (FileNotFoundException exception) {
                System.out.println("The boot file was not found!");
            } catch (NoSuchElementException exception) {
                System.out.println("The boot file is empty!");
            } catch (JsonParseException exception) {
                System.out.println("The required collection was not found in the download file");
            } catch (IllegalStateException | IOException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            }
        } else {
            System.out.println("Аргумент командной строки с загрузочным файлом не найден!");
        }
        return new PriorityQueue<>();
    }
}