package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.IntStream;

public class Reduce implements SingleLink<Integer> {

    List<Integer> arrayList;
    @Override
    public Integer getHeaderData() {
        return this.arrayList.get(0);
    }

    @Override
    public Integer getTailData() {
        return this.arrayList.get(this.arrayList.size() - 1);
    }

    @Override
    public int size() {
        return this.arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override
    public Integer getNode(int index) {
        return this.arrayList.get(index - 1);
    }

    @Override
    public boolean deleteFirst() {
        return this.arrayList.remove(this.getHeaderData());
    }

    @Override
    public boolean deleteLast() {
        return this.arrayList.remove(this.getTailData());
    }

    @Override
    public void addHeadPointer(Integer item) {
        this.arrayList.add(0, item);
    }

    @Override
    public void addTailPointer(Integer item) {
        this.arrayList.add(item);
    }
    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public double getMinimum() {
        return arrayList.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public double getOrderedMedian() {
        int len = arrayList.size();
        if(len%2==1){
            return arrayList.get(len/2);
        }else{
            return (arrayList.get(len/2-1)+arrayList.get(len/2))/2.0;
        }
    }

    public int getFirstEven() {
        return this.arrayList.stream().filter(num -> num % 2 == 0).findFirst().orElse(0);

    }

    public int getIndexOfFirstEven() {
        return IntStream.range(0, this.arrayList.size())
                .filter(id -> this.arrayList.get(id) % 2 == 0)
                .findFirst().orElse(0);
    }

    public boolean isEqual(List<Integer> list) {
        if(arrayList.size()!=list.size()) return false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != list.get(i)) return false;
        }
        return true;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        this.arrayList.stream().sorted()
                .mapToInt(num -> num)
                .forEach(singleLink::addTailPointer);
        int len = this.arrayList.size();
        if(len%2==0) {
            return (double) ((int) singleLink.getNode(len / 2) + (int) singleLink.getNode(len / 2 + 1)) / 2;
        }
        return (double)(int) singleLink.getNode(len / 2);
    }

    public int getLastOdd() {
        return this.arrayList.stream().filter(num -> num % 2 != 0)
                .reduce(0, (num1, num2) -> num2);
    }

    public int getIndexOfLastOdd() {
        return IntStream.range(0, this.arrayList.size())
                .filter(id -> this.arrayList.get(id) % 2 != 0)
                .reduce(0, (id1, id2) -> id2);
    }
}
