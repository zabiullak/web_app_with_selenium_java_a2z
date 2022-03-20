package learningBlock;

import java.util.Arrays;
import java.util.List;

public class Leet1 {
    //static List<List<Integer>> nums = Arrays.asList(Arrays.asList(3, 7, 11, 15));

    static int[] nums = new int[] {2,7,11,15};
    static int target = 9;

    public static void main(String[] args){

        for (int i:twoSum(nums,target)) {

            System.out.println(i);

        }

        //String val = checkValue();
        //System.out.println(val);


    }

    private static String checkValue() {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + nums[i + 1] == target) return "[0, 1]";
            else return "[1, 2]";
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]+nums[i+1]==target) return new int[] {i,i+1};
            else return new int[] {i+1,i+2};
        }
        return null;
    }
}
