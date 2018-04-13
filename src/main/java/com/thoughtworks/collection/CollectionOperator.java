package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> list = new ArrayList<>();
        if(left<=right){
            for (int i = left; i <= right; i++) {
                list.add(i);
            }
        }else{
            for (int i = left; i >= right; i--) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {

        List<Integer> list = new ArrayList<>();
        if(left<=right){
            for (int i = left; i <= right; i++) {
                if(i%2==0) list.add(i);
            }
        }else{
            for (int i = left; i >= right; i--) {
                if(i%2==0) list.add(i);
            }
        }
        return list;
    }

    public List<Integer> popEvenElments(int[] array) {
        return IntStream.of(array).boxed()
                .collect(Collectors.toList()).stream().filter(i->i%2==0)
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {

        List<Integer> list1 = IntStream.of(firstArray).boxed()
                .collect(Collectors.toList());

        List<Integer> list2 = IntStream.of(secondArray).boxed()
                .collect(Collectors.toList())
                .stream()
                .filter(item -> list1.contains(item))
                .collect(Collectors.toList());
        return list2;

    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list1
                = Arrays.asList(firstArray)
                .parallelStream()
                .collect(Collectors.toList());
        List<Integer> list2
                = Arrays.asList(secondArray).stream()
                .filter(item -> !list1.contains(item))
                .collect(Collectors.toList());
        list1.addAll(list2);
        return list1;
    }
}
