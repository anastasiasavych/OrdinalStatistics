package com.company;
import java.util.*;
public class Main {

    public static void nth_element(int[] arr, int first, int last, int n) {
        while (true) {
            int k = randomizedPartition(arr, first, last);
            if (n < k)
                last = k;
            else if (n > k)
                first = k + 1;
            else
                return;
        }
    }

    static Random rnd = new Random();

    static int randomizedPartition(int[] arr, int first, int last) {
        swap(arr, first + rnd.nextInt(last - first), last - 1);
        int p = arr[last - 1];
        int i = first - 1;
        for (int j = first; j < last; j++)
            if (arr[j] <= p)
                swap(arr, ++i, j);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {45,24,32,47,22,26,28,38,47,51,35,32,28,32,30};
        System.out.println("Масив вікових даних співробітників відділу 'Роботи з персоналом':");
        System.out.println(Arrays.toString(arr));

        int k = rnd.nextInt(15);
        nth_element(arr, 0, arr.length, k);
        System.out.println("Порядкова статистика масиву з iндексом " + k + " містить значення: " + arr[k]);
        }
    }


