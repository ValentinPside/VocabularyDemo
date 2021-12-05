package ru.avalon.javapp.devj120.countrydemo;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите имя файла для обработки в формате text.txt");
        //Адрес для введения в консоль:
        //       src\Pushkin-Kapitanskaya_dochka-ch2.txt
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        TextExecutor file = new TextExecutor(fileName);
    }
}
