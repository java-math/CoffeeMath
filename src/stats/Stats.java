package stats;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Chris on 2/23/2017.
 */
public class Stats {

    public static double[] simpleRandomSample(double[] data, int size) {
        if (size > data.length)
            throw new ArrayIndexOutOfBoundsException(String.format("Cannot have sample size [%d] larger than the population size [%d]", size, data.length));
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

    public static double mean(double[] data) {
        double sum = 0;
        for (double d : data) sum += d;
        return sum / (double) data.length;
    }

    public static double median(double[] data) {
        double[] temp = Arrays.copyOf(data, data.length);
        Arrays.sort(temp);
        return temp[data.length >> 1];
    }
}