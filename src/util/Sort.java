package util;

/**
 * Created by Chris on 2/24/2017.
 */
public class Sort {

    public static Double[] mergeSort(Comparable[] arr) {
        Comparable[] temp = new Comparable[arr.length];
        mergeSort(arr, temp, 5, 10);
        return null;
    }

    private static void mergeSort(Comparable[] a, Comparable[] temp, int left, int right) {
        if(left < right) {
            int center = (left + right) >> 1;
            mergeSort(a, temp, left, center);
            mergeSort(a, temp, center + 1, right);
            merge(a, temp, left, center + 1, right);
        }
    }

    private static void merge(Comparable[] e, Comparable[] temp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd) {
            if (e[left].compareTo(e[right]) <= 0)
                temp[k++] = e[left++];
            else
                temp[k++] = e[right++];
        }

        while(left <= leftEnd)
            temp[k++] = e[left++];
        while(right <= rightEnd)
            temp[k++] = e[right++];

        for(int i = 0; i < num ; i++, rightEnd--) {
            e[rightEnd] = temp[rightEnd];
        }
    }
}
