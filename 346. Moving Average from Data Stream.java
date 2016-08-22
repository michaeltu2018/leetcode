public class MovingAverage {
    int[] x;
    int pointer = 0;
    long sum;
    int curSize = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        x = new int[size];
        sum = 0;
    }
    
    public double next(int val) {
        if(curSize < x.length) curSize++;
        this.sum -= x[pointer];
        this.sum += val;
        x[pointer] = val;
        pointer = (pointer+1)%x.length;
        return (double)sum/(double)curSize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
