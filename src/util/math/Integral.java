package util.math;

import com.sun.istack.internal.Nullable;

/**
 * Created by Chris on 2/24/2017.
 */
public class Integral {

    private CSFunction function;
    private double lowerBound;
    private double upperBound;
    private double answer;
    private int divisions;

    public Integral() {
        this(null, 0, 10);
    }

    public Integral(@Nullable CSFunction f, double lb, double ub) {
        this(f, lb, ub, 1000);
    }

    public Integral(@Nullable CSFunction f, double lb, double ub, int divs) {
        this.function = f;
        this.lowerBound = lb;
        this.upperBound = ub;
        this.answer = 0;
        this.divisions = divs;
    }

    public void setFunction(CSFunction f) {
        this.function = f;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    public void setDivisions(int d) {
        this.divisions = d;
    }

    public int getDivisions() {
        return divisions;
    }

    public double getAnswer() {
        return answer;
    }

    public void calculate() {
        if(upperBound - lowerBound < 1) throw new IntegrationRangeTooSmallException(upperBound, lowerBound);
        if(function == null) throw new InvalidFunctionException("Function cannot be null.");
        calculateIntegral(this.divisions);
    }

    private void calculateIntegral(int divisions) {
        double stepSize = (upperBound - lowerBound) / (double) divisions;
        double sum = 0;
        for(double i = lowerBound ; i <= upperBound ; i += stepSize) {
            sum += ((function.calculate(i) + function.calculate(i + stepSize))/2)*stepSize;
        }
        answer = sum;
    }
}

class IntegrationRangeTooSmallException extends RuntimeException {
    public IntegrationRangeTooSmallException(double upperBound, double lowerBound) {
        super(String.format("Lower bound %.1f and upper bound %.1f must be at least 1 apart.", lowerBound, upperBound));
    }
}

class InvalidFunctionException extends RuntimeException {
    public InvalidFunctionException(String msg) {
        super(msg);
    }
}