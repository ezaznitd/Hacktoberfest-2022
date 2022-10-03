import java.util.Stack;
  
class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        Stack<Integer> middleStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min){
                minStack.push(num);
                min = num;
            }
        }
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] <= minStack.peek()){
                if(nums[i] == minStack.peek()){
                    minStack.pop();
                }
                continue;
            } else {
                while(!middleStack.isEmpty() && middleStack.peek() < nums[i]){
                    if(middleStack.peek() > minStack.peek()){
                        return true;
                    } else{
                        middleStack.pop();
                    }
                }
                middleStack.push(nums[i]);
                if(nums[i] == minStack.peek()){
                    minStack.pop();
                }
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        OneThreeTwoPattern oneThreeTwoPattern = new OneThreeTwoPattern();
        int[] nums = new int[] {3,1,4,2};
        if (oneThreeTwoPattern.find132pattern(nums)) {
            System.out.println("132 Pattern found");
        }
        else {
            System.out.println("132 Pattern not found");
        }
    }
}
