package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */

public class LC_346_MovingAverageFromDataStream {
    private int windowSize;
    private int sum;
    private int count;
    private Deque<Integer> window;

    public LC_346_MovingAverageFromDataStream(int windowSize) {
        this.windowSize = windowSize;
        window = new ArrayDeque<>();
    }

    public double next(int nextStream) {
        if(window.size() == windowSize) {
            sum -= window.removeFirst();
        } else {
            count++;
        }
        window.addLast(nextStream);
        sum += nextStream;

        return (double) sum / count;
    }
}

/*
//This is not the best solution, if the window size is too much, we are re summing the old streams, instead we can do
//something like the following method
public class easy.LC_346_MovingAverageFromDataStream {
    private int windowSize;
    private Deque<Integer> window;

    public easy.LC_346_MovingAverageFromDataStream(int windowSize) {
        this.windowSize = windowSize;
        window = new ArrayDeque<>();
    }

    public double next(int nextStream) {
        if(window.size() == windowSize) {
            window.removeFirst();
        }
        window.addLast(nextStream);

        double movingAvg = calculateAverage(window);

        return movingAvg;
    }

    private double calculateAverage(Deque<Integer> window) {
        int total = 0;
        for(Integer i : window) {
            total += i;
        }
        return total / windowSize;
    }
 */
