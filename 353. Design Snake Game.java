public class SnakeGame {
    //int[][] table;
    int[][] food;
    int foodIndex = 0;
    int w;
    int h;
    Set<Integer> occupied = new HashSet<Integer>();
    Deque<Integer> list = new LinkedList<Integer>();
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        //table = new int[height][width];
        this.food = food;
        occupied.add(0);
        list.add(0);
        this.w = width;
        this.h = height;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(foodIndex > food.length){
            return -1;
        }
        if(list.size() > w*h){
            return -1;
        }
        Integer last = list.getLast();
        int newX = last/w;
        int newY = last%w;
        if(direction.equals("U")){
            newX--;
        }
        else if(direction.equals("L")){
            newY--;
        }
        else if(direction.equals("D")){
            newX++;
        }
        else if(direction.equals("R")){
            newY++;
        }
        if(newX >= h || newX < 0 || newY >= w || newY <0){
            //System.out.println("newX:" + newX);
            //System.out.println("newY:" + newY);
            return -1;
        }
        int currIndex = newX*w + newY;
        
        if(occupied.contains(currIndex)){
            Integer first = list.getFirst();
            if((first) != (currIndex)) return -1;
        }
        else{
            occupied.add(currIndex);
        }
        list.add(currIndex);
        if(foodIndex < food.length && food[foodIndex][0] == newX && food[foodIndex][1] == newY){

            return ++foodIndex;
        }
        else{
            Integer first = list.getFirst();
            if((first) != (currIndex)) occupied.remove(first);
            list.removeFirst();
            return foodIndex;
        }
        
    }
}



/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
