package sample.logic;

import javafx.concurrent.Task;

public class DivisorCounter extends Task<Result> {

    private final int minimum;
    private final int maximum;

    public DivisorCounter(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }


    public Result calculate(int minimum, int maximum) {
        Result result = new Result(0, 0);
        for(int i = minimum; i <= maximum; i++) {
            int counter = 0;
            for(int j = 1; j<=i; j++) {
                if(i % j == 0) {
                    counter++;
                }
            }
            if(counter > result.getDivisorCounter()) {
                result = new Result(i, counter);
                updateValue(result);
            }
            updateProgress(i, maximum);
        }

        return result;
    }

    @Override
    protected Result call() throws Exception {
        return calculate(minimum, maximum);
    }
}
