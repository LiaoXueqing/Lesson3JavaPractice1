package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(i->i*3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        List<String> result = new ArrayList<>();
        array.forEach(i->
                result.add(letterList.get(i-1))
        );
        return result;
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<>();
        array.forEach(i-> {
            String s;
            if(i>26){
                if(i%26==0){
                    s = letterList.get((i-1)/26-1) + letterList.get((i-1)%26);
                }else{
                    s = letterList.get(i/26-1) + letterList.get((i-1)%26);
                }
            }else{
                s = letterList.get(i  - 1);
            }
            result.add(s);
        });
        return result;
    }

    public List<Integer> sortFromBig() {
       return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {

        return array.stream().sorted().collect(Collectors.toList());
    }
}
