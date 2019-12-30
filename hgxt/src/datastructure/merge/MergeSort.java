package datastructure.merge;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){
        String[] array = new String[]{"2","1","6","9","5","7","11"};
        System.out.println("排序前："+ Arrays.toString(array));
        System.out.println("\r\n排序后："+ Arrays.toString(MergeSort.merge(array)));
    }

    public static String[] merge(String[] array) {
        if(array==null||array.length<=1) {
            return array;
        }
        int length = array.length;
        int index = length/2;
        //mergeSort(Array.)
        String newArray[] = new String[length];
        while(index>1){
            index = length / 2;
        }
        return null;
    }

}
