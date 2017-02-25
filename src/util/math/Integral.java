package util.math;

/**
 * Created by Chris on 2/24/2017.
 */
public class Integral {

    private CSFunction function;
    private double lowerBound;
    private double upperBound;

    private int currentStep;

    public Integral() {
        function = null;
        lowerBound = 0;
        upperBound = 0;
        currentStep = 0;
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

    public double calculate() {
        if(upperBound - lowerBound < 0.5) throw new IntegrationRangeTooSmallException(upperBound, lowerBound);
        return calculateIntegral();
    }

    private double calculateIntegral() {
        double stepSize = 0.5;
        for(double i = lowerBound ; i < upperBound ; i += stepSize) {

        }
        return 0.0;
    }
}

class IntegrationRangeTooSmallException extends RuntimeException {
    public IntegrationRangeTooSmallException(double upperBound, double lowerBound) {
        super(String.format("Upper bound %.1f and lower bound %.1f must be at least 0.5 apart.", upperBound, lowerBound));
    }
}