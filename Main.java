package ru.avalon.javapp.devj120.VocabularyDemo;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        checkFile(args);
        if(args.length == 0)
            help();
        checkFile(args);
        FileNameHandler f = new FileNameHandler(args);

    }
    private static void help() {
        System.out.println("Программа производит подсчёт количества и частоты употребления слов в текстовом файле.\n" +
                "Название текстового файла следует ввести в параметры командной строки.\n" +
                "Пример: Pushkin-Kapitanskaya_dochka-ch2\n");
        System.exit(0);
    }

    private static void checkFile(String[] args) {
        for(String fileName : args){
        File file = new File(fileName);
        if (!file.isFile()) {
            System.out.println("\"" + fileName + "\" не является файлом.");
            System.exit(1);
        }
        }
    }
}
