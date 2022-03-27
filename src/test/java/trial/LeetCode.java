package trial;

import jnr.ffi.annotations.In;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {

    @Test
    public void test2085(){
        int count = countWords(new String[]{"leetcode","is","amazing","as","is"},new String[]{"amazing","leetcode","is"});
        System.out.println(count);
    }

    public int countWords(String[] words1, String[] words2) {

        List<String> list1 = new ArrayList<>(Arrays.asList(words1));
        List<String> list2 = new ArrayList<>(Arrays.asList(words2));
        List<String> buffer = new ArrayList<>();

        int count=0;
        Iterator<String> iter =  list1.iterator();
        while (iter.hasNext()){
            String next = iter.next();
            if(Collections.frequency(list1,next)>1){
                buffer.add(next);
            }
        }

        iter = buffer.iterator();
        while (iter.hasNext()){
            String buff = iter.next();
            if(list1.contains(buff)){
                list1.remove(buff);
            }
        }
        buffer.clear();
        iter =  list2.iterator();
        while (iter.hasNext()){
            String next = iter.next();
            if(Collections.frequency(list2,next)>1){
                buffer.add(next);
            }
        }

        iter = buffer.iterator();
        while (iter.hasNext()){
            String buff = iter.next();
            if(list2.contains(buff)){
                list2.remove(buff);
            }
        }


        for (String val: list1) {
            if(list2.contains(val)){
                count++;
            }
        }
        return count;
    }

    @Test
    public void test2215(){
        List<List<Integer>> list = findDifference(new int[]{1,2,3},new int[]{2,4,6});
        Iterator<List<Integer>> iter = list.iterator();

        System.out.print("[");
        while (iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(", ");
        }
        System.out.print("]");

    }

    @Test
    public void test349(){
        int[] arr = intersection(new int[]{1,2,2,1},new int[]{2,2});
        //System.out.println(arr.toString());

    }
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();


        for (int num: nums1) {
            s1.add(num);
        }

        for (int num: nums2) {
            s2.add(num);
        }

        s1.retainAll(s2);

        int[] arr = new int[s1.size()];

        int index=0;
        for (int val: s1) {
            arr[index++]= val;
        }
        return  arr;

    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int no : nums1) {
            set1.add(no);
        }
        for (int no : nums2) {
            set2.add(no);
        }
        List<Integer> list1 = new ArrayList<>(set1);
        List<Integer> list2 = new ArrayList<>(set2);
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();


        Iterator<Integer> iter1 = set1.iterator();


       while (iter1.hasNext()){
           int val1 = iter1.next();
           //int pos = Collections.binarySearch(list1,val1);
           if(!list2.contains(val1)){
               list3.add(val1);
           }
       }
       ans.add(list3);

        Iterator<Integer> iter2 = set2.iterator();
        while (iter2.hasNext()){
            int val2 = iter2.next();
            //int pos = Collections.binarySearch(list1,val1);
            if(!list1.contains(val2)){
                list4.add(val2);
            }
        }
        ans.add(list4);
        return ans;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ArrayList<Integer> arrlst = new ArrayList<>();


        return new ListNode();
    }

    @Test
    public void test3(){
        int[] arrylst = {1,2,5,8};
        List<Integer> list = (ArrayList<Integer>) Arrays.stream(arrylst).boxed().collect(Collectors.toList());
        List<Integer> removelist = new ArrayList<>();
        removelist.add(2);
        removelist.add(5);
        list.removeAll(removelist);
        System.out.println(list.get(0));
    }

    @Test
    public void test2(){
        /*
        * You are given an array people where people[i] is the weight of the ith person, and an
        * infinite number of boats where each boat can carry a maximum weight of limit. Each boat
        * carries at most two people at the same time, provided the sum of the weight of those people
        * is at most limit.

        Return the minimum number of boats to carry every given person.

        Example 1:

        Input: people = [1,2], limit = 3
        Output: 1
        Explanation: 1 boat (1, 2)
        Example 2:

        Input: people = [3,2,2,1], limit = 3
        Output: 3
        Explanation: 3 boats (1, 2), (2) and (3)
        Example 3:

        Input: people = [3,5,3,4], limit = 5
        Output: 4
        Explanation: 4 boats (3), (3), (4), (5)
        * */
        Assert.assertEquals(numRescueBoats(new int[]{3,2,2,1},3),3);
        Assert.assertEquals(numRescueBoats(new int[]{3,5,3,4},5),4);
        Assert.assertEquals(numRescueBoats(new int[]{1,2},3),1);
        Assert.assertEquals(numRescueBoats(new int[]{2,2},6),1);
        Assert.assertEquals(numRescueBoats(new int[]{2,5,5,5},5),4);
        Assert.assertEquals(numRescueBoats(new int[]{5,1,4,2},6),2);
        Assert.assertEquals(numRescueBoats1(new int[]{3,8,7,1,4},9),3);
        Assert.assertEquals(numRescueBoats1(new int[]{2,3,5,1},5),3);
        numRescueBoats(new int[]{3,5,3,4},5);

    }

    public int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }
    public int numRescueBoats(int[] people, int limit) {

        int noOfBoats = 0;
        ArrayList<Integer>  remainingPeople= (ArrayList<Integer>) Arrays.stream(people).boxed().collect(Collectors.toList());
        for(int i=0;i<people.length;i++) {
            if(people[i]==limit){
                noOfBoats++;
                remainingPeople.remove(Integer.valueOf(people[i]));
            }
        }
        Collections.sort(remainingPeople,Collections.reverseOrder());
        while(remainingPeople.size()>0){
            if(remainingPeople.size()==1){
                noOfBoats++;
                remainingPeople.remove(0);
            }
            else{
                for(int i=0;i<remainingPeople.size()-1;i++){
                    for(int j=i+1;j<remainingPeople.size();j++){

                        if(i!=j){
                            int totalWeight = remainingPeople.get(i)+remainingPeople.get(j);
                            if(totalWeight==limit){
                                noOfBoats++;
                                remainingPeople.remove(j);
                                remainingPeople.remove(i);
                                i=-1;j=-1;
                                break;
                            }
                            else if(totalWeight<limit){
                                noOfBoats++;
                                remainingPeople.remove(j);
                                remainingPeople.remove(i);
                                i=-1;j=-1;
                                break;
                            }
                        }
                    }
                }
                noOfBoats =  noOfBoats+remainingPeople.size();
                remainingPeople.clear();
            }
        }
        return noOfBoats;
    }
    @Test
    public void addNum(){

        System.out.println(twoSum(new int[]{3,2,4},6));
        System.out.println(twoSum(new int[]{4,4,6},8));
        System.out.println(twoSum(new int[]{4,4,6,7,4,1},8));
    }

    public int[] twoSum(int[] nums, int target) {
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

    @Test
    public void test1(){
        /*
        * Given an integer x, return true if x is palindrome integer.
          An integer is a palindrome when it reads the same backward as forward.
          For example, 121 is a palindrome while 123 is not.
        * */
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(123));
    }
    public boolean isPalindrome(int x) {
        String normal = Integer.toString(x);
        String reverse = "";

        for(int i=0;i<normal.length();i++){
            reverse =  normal.charAt(i)+reverse;
        }
        if(normal.equals(reverse)) return true;
        else return false;
    }


}
