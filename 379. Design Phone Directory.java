public class PhoneDirectory {
    Set<Integer> used;
    Queue<Integer> avail;
    int max;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        used = new HashSet<>();
        avail = new LinkedList<>();
        max = maxNumbers;
        for(int i=0;i<maxNumbers;i++){
            avail.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(avail.size() == 0){
            return -1;
        }
        int res = avail.poll();
        used.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(used.contains(number)){
            used.remove(number);
            avail.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
