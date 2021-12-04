package ru.avalon.javapp.devj120.countrydemo;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class TextExecutor {

    public TextExecutor(String fileName) throws IOException {
        if(fileName == null)
            throw new IllegalArgumentException("fileName can't be null.");
        divide(new File(fileName));
    }

    private void divide(File fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        HashMap<String, Integer> vocabulary = new HashMap<>();
        String word = null;
        int count = 0;
        String[] lines = br.lines().toArray(String[]::new);

        for (int i = 0; i < lines.length; i++){;
            String[] words = lines[i].split(" ");
            for (String w:words){
                 w = w.replaceAll("[()—.:,?!;«»…]", "").toLowerCase();
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
            words = null;
        }
        Set<String> slovo = vocabulary.keySet();
        for (String i : slovo){
            System.out.println("Слово " + i + " встречается в данном тексте " + vocabulary.get(i) + " раз;");
        }

    }

}
