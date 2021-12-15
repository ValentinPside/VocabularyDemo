package ru.avalon.javapp.devj120.VocabularyDemo;

public class FileWord {
    private int count;
    private String word;

    public FileWord(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
