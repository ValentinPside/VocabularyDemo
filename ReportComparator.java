package ru.avalon.javapp.devj120.countrydemo;

import java.util.Comparator;

public class ReportComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int a = Integer.parseInt(o1.toString().replaceAll("[а-яё=]", ""));
        int b = Integer.parseInt(o2.toString().replaceAll("[а-яё=]", ""));
        String c = String.valueOf(o1).replaceAll("[0-1=]", "");
        String d = String.valueOf(o2).replaceAll("[0-1=]", "");
        if(a - b > 0){
            return 1;
        }
        else if(a - b < 0){
            return -1;
        }
        else {
            if(c.compareTo(d) > 0){
                return 1;
            }
            else if (c.compareTo(d) < 0){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}
