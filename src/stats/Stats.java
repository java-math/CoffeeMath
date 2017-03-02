package stats;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Chris on 2/23/2017.
 */
public class Stats {

    public static double[] simpleRandomSample(@NotNull double[] data, int size) {
        if (size > data.length)
            throw new ArrayIndexOutOfBoundsException(String.format("Cannot have sample size [%d] larger than the population size [%d]", size, data.length));
        if(size == 0) size = data.length;
        Random r = new Random();
        double[] sample = new double[size];
        boolean[] indices = new boolean[data.length];
        for (int i = 0; i < size; i++) {
            int index = r.nextInt(data.length);
            while (indices[index]) index = r.nextInt(size);
            indices[index] = true;
            sample[i] = data[index];
        }
        return sample;
    }

    public static double mean(@NotNull double[] data) {
        double sum = 0;
        for (double d : data) sum += d;
        return sum / (double) data.length;
    }

    public static double median(@NotNull double[] data) {
        double[] temp = Arrays.copyOf(data, data.length);
        Arrays.sort(temp);
        return temp[data.length >> 1];
    }

    public static double mode(@NotNull double[] data) {
        double[] temp = Arrays.copyOf(data, data.length);
        Arrays.sort(temp);

        double most = temp[0];
        int count = 1;
        int index = 1;
        while(index < temp.length) {
            double tempMost = temp[index];
            int tempCount = 0;
            while (temp[index] == most) {
                tempCount++;
                index++;
            }
        }
    }

    public static double range(@NotNull double[] data) {
        double[] temp = Arrays.copyOf(data, data.length);

        double min = temp[0];
        double max = temp[0];

        //Find min
        for(int i = 0 ; i < temp.length ; i++) {
            if(temp[i] < min) min = temp[i];
            if(temp[i] > max) max = temp[i];
        }

        return max - min;
    }
}