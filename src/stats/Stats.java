package stats;

import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Chris on 2/23/2017.
 */
public class Stats {

    public static double[] simpleRandomSample(double[] data, int size) {
        if(size > data.length) throw new ArrayIndexOutOfBoundsException(String.format("Cannot have sample size [%d] larger than the population size [%d]", size, data.length));
        Random r = new Random();
        double[] sample = new double[size];
        boolean[] indices = new boolean[data.length];
        for(int i = 0; i < size ; i++) {
            int index = r.nextInt(data.length);
            while(indices[index]) index = r.nextInt(size);
            indices[index] = true;
            sample[i] = data[index];
        }
        return sample;
    }

    public static double mean(double[] data) {
        double sum = 0;
        for(double d : data) sum += d;
        return sum/(double)data.length;
    }

    public static double median(double[] data) {
    }

    //Using counting sort: http://bigocheatsheet.com/
    private static double[] sort(double[] array) {
        Pair[] count = new Pair[array.length];
        for(int i = 0; i < array.length ; i++) {
            if(count[i] == null) count[i] = new Pair(array[i]);
            count[i].increment();
        }
        int total = 0;

        for(int i = 0; i < array.length ; i++) {
            int oldCount = count[i].right;
            count[i].right = total;
            total += oldCount;
        }

        for(double d : array) {

        }
    }
}

class Pair {
    public double left;
    public int right;

    public Pair(double l) {
        this.left = l;
        this.right = 0;
    }

    public void increment() {
        right++;
    }
}
