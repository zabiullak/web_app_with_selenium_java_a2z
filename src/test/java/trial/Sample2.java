package trial;

import java.util.ArrayList;
import java.util.Collections;

public class Sample2 {
    public static void main(String[] args){
        System.out.println("fff");

        ArrayList nums = new ArrayList(Collections.singleton(new int[]{2, 7, 11, 15}));

        int[] num = {2,7,11,15};
        twoSum(new int[]{3,2,4},6);
    }



    public static int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=0;j<nums.length;j++){
                if(j!=i){
                if(nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                    }
                }
            }
        }
        return null;
    }
}
