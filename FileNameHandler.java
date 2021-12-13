package ru.avalon.javapp.devj120.countrydemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileNameHandler {

    private ArrayList<String> fileNamesList;

    public FileNameHandler(String[] fileNames) throws IOException {
        setFileNamesList(fileNames);
        for(String i : fileNamesList){
            TextExecutor file = new TextExecutor(i);
        }
    }

    public void setFileNamesList(String[] fileNames) throws IOException {
        if(fileNames.length != 0){
            fileNamesList = new ArrayList<>();
            this.fileNamesList.addAll(Arrays.asList(fileNames));
        }
        else {
            throw new IOException("Не введено ни одного имени файла");
        }
    }
    public ArrayList<String> getFileNamesList() {
        return fileNamesList;
    }

}
