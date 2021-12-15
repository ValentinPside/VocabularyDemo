package ru.avalon.javapp.devj120.VocabularyDemo;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TextExecutor {
    private HashMap<String, Integer> vocabulary = new HashMap<>();
    private int wordsSum = 0;
    ArrayList<FileWord> fileWords = new ArrayList<>();
    private String report1 = "";
    private String report2 = "";

    public TextExecutor(String fileName) throws IOException {
        if(fileName == null){
            throw new IllegalArgumentException();}
        else{
            divide(new File(fileName));
        }
    }

    private void divide(File fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String[] lines = br.lines().toArray(String[]::new);
        br.close();


        for (int i = 0; i < lines.length; i++){
            String[] words = lines[i].split(" ");
            for (String w:words){
                w = w.replaceAll("[()—.:,?!;«»…*0-9A-Z]", "").toLowerCase();
                if(w.isBlank()){
                    continue;
                }
                if (w.equals("-") || w.equals(" ")){
                    continue;
                }
                else if(!vocabulary.containsKey(w)){
                    vocabulary.put(w, 1);
                }
                else if(vocabulary.containsKey(w)){
                    vocabulary.put(w, vocabulary.get(w)+1);
                }
            }
        }
        for(String i : vocabulary.keySet()){
            fileWords.add(new FileWord(i, vocabulary.get(i)));
        }

        for(int i : vocabulary.values()){
            wordsSum = wordsSum + i;
        }
        reportOne(fileName.getName());
        reportTwo(fileName.getName());
    }

    private void reportOne(String fileName){

        Object[] sorted = vocabulary.keySet().stream().sorted().toArray();

        for (Object i : sorted){
            double a = (double)vocabulary.get(i) / (double) wordsSum;
            DecimalFormat decimalFormat = new DecimalFormat("#.####");
            String b = decimalFormat.format(a);
            String text = "Слово " + "'" + i + "'" + " встречается в данном тексте " + vocabulary.get(i) + " раз;\n" +
                    "Относительная частота этого слова " + b + "\n";
            report1 += text;
        }

        try(FileWriter writer = new FileWriter(fileName + " report1.txt", true)) {
            writer.write(report1);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private void reportTwo(String fileName){
        Comparator myComparator = new MyComparator();
        Collections.sort(fileWords, myComparator);

        for (FileWord i : fileWords){
            double a = (double)i.getCount() / (double) wordsSum;
            DecimalFormat decimalFormat = new DecimalFormat("#.####");
            String b = decimalFormat.format(a);
            String text = "Слово " + "'" + i.getWord() + "'" + " встречается в данном тексте " + i.getCount() + " раз;\n" +
                    "Относительная частота этого слова " + b + "\n";
            report2 += text;
        }

        try(FileWriter writer = new FileWriter(fileName + " report2.txt", true)) {
            writer.write(report2);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
