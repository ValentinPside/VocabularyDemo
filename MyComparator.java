package ru.avalon.javapp.devj120.VocabularyDemo;

import java.util.Comparator;

public class MyComparator implements Comparator<FileWord> {

    @Override
    public int compare(FileWord o1, FileWord o2) {
        if(o1.getCount() == o2.getCount()){
            return o1.getWord().compareTo(o2.getWord());
        }
        else {
            return o2.getCount() - o1.getCount();
        }
    }
}
