package ru.avalon.javapp.devj120.countrydemo;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class TextExecutor {

    public TextExecutor(String fileName) throws IOException {
        if(fileName == null)
            throw new IllegalArgumentException("fileName can't be null.");
        divide(new File(fileName));
    }

    private void divide(File fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        HashMap<String, Integer> vocabulary = new HashMap<>();

        String[] lines = br.lines().toArray(String[]::new);
        int wordsSum = 0;

        for (int i = 0; i < lines.length; i++){;
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
                    vocabulary.replace(w, vocabulary.get(w), vocabulary.get(w)+1);
                }
            }
        }

        for(int i : vocabulary.values()){
            wordsSum = wordsSum + i;
        }

        TreeMap sorted = new TreeMap();
        sorted.putAll(vocabulary);
        Set<String> words = sorted.keySet();

        for (String i : words){
            double a = (double)vocabulary.get(i) / (double) wordsSum;
            DecimalFormat decimalFormat = new DecimalFormat("#.####");
            String b = decimalFormat.format(a);
            String text = "Слово " + "'" + i + "'" + " встречается в данном тексте " + vocabulary.get(i) + " раз;\n" +
                    "Относительная частота этого слова " + b + "\n";
            try(FileWriter writer = new FileWriter("report1.txt", true)) {
            writer.write(text);
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }

        Object[] sorted2 = sorted.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).toArray();
        for(Object i : sorted2){
            String a = i.toString();
            a = a.replaceAll("[а-яё=]", "");
            double b = Double.parseDouble(a);
            double c = b / (double) wordsSum;
            DecimalFormat decimalFormat = new DecimalFormat("#.####");
            String d = decimalFormat.format(c);
            String text = "Слово " + i + " повторения в данном тексте " + "\n" +
                    "Относительная частота этого слова " + d + "\n";
            try(FileWriter writer = new FileWriter("report2.txt", true)) {
                writer.write(text);
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}