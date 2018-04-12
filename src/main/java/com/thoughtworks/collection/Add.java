package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int min = leftBorder>rightBorder?rightBorder:leftBorder;
        int max = leftBorder>rightBorder?leftBorder:rightBorder;
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if(i%2 == 0){
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int min = leftBorder>rightBorder?rightBorder:leftBorder;
        int max = leftBorder>rightBorder?leftBorder:rightBorder;
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if(i%2 == 1){
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(i-> i*3+2)
                .collect(Collectors.toList())
                .stream().mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(
                i-> { if(i%2==0) return i;else return i*3+2;}
                ).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().map(i-> { if(i%2==1) return i*3+5; return 0;})
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list =arrayList.stream().filter(i->i%2==0)
                .collect(Collectors.toList());
        if(list.size()%2==0) return (list.get((list.size()-1)/2)+list.get(list.size()/2))/2;
        return list.get(list.size()/2);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return  arrayList.stream().filter(i->i%2==0)
                .mapToDouble(Integer::intValue)
                .average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return  arrayList.stream()
                .filter(i->i%2==0)
                .collect(Collectors.toList())
                .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return  arrayList.stream()
                .filter(i->i%2==0).distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenlist = arrayList.stream()
                .filter(i->i%2==0).sorted().collect(Collectors.toList());
        List<Integer> oddlist = arrayList.stream()
                .filter(i->i%2!=0)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        list.addAll(evenlist);
        list.addAll(oddlist);
        return list;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
