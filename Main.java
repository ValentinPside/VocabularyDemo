package ru.avalon.javapp.devj120.countrydemo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] fileNames = {"src\\Pushkin-Kapitanskaya_dochka-ch2.txt"};
        FileNameHandler f = new FileNameHandler(fileNames);
    }
}
