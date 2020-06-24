/*448. Find All Numbers Disappeared in an Array

        Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

        Find all the elements of [1, n] inclusive that do not appear in this array.

        Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.*/

import java.util.*;

public class leet448 {
/*    public static List<Integer> findDisappearedNumbers(int[] nums) {

//WRONG LOGIC

        Arrays.sort(nums);
        //System.out.println(nums);
        //String nums1=Arrays.toString(nums);
        System.out.println("Sorted array: "+Arrays.toString(nums));
        ArrayList<Integer> arrayList=new ArrayList<>();
        Integer[] nums1=new Integer[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            nums1[i]=Integer.valueOf(nums[i]);
        }

        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>(Arrays.asList(nums1));

        Integer[] nums1withoutduplicates=linkedHashSet.toArray(new Integer[]{});
        System.out.println("Without Duplicates: "+Arrays.toString(nums1withoutduplicates));

        for (int i=0;i<nums1withoutduplicates.length;i++)
        {
            if(nums1withoutduplicates[i]!=i+1)
            {
                arrayList.add(i+1);
            }
        }
        return arrayList;
    }*/



/*
public static List<Integer> findDisappearedNumbers(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
        int val = Math.abs(nums[i]) - 1;
        if (nums[val] > 0) {
            nums[val] = -nums[val];
        }
    }

    List<Integer> result = new ArrayList();
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            result.add(i + 1);
        }
    }
    return result;
}

*/

public static List<Integer> findDisappearedNumbers(int[] nums)
{
    /*
    Take the max of the largest number in the array or the array size. Create a hashmap of that size, initialized with 0.
    Compare the indices of the nums array with the map, and mark them with one. The numbers that are not present in the array will remain 0 in the map.
     */
    int max=Integer.MIN_VALUE;
    for(int i:nums)
    {
        max=Math.max(max,i);
    }
    max=Math.max(max,nums.length);

    Map<Integer,Integer> map= new HashMap();
    for(int i=1;i<=max;i++)
    {
        map.put(i,0);
    }
    for(int j:nums)
    {
        if(map.get(j)==0)
            map.put(j,1);
        else
            map.put(j,map.get(j)+1);
    }
    List<Integer> result=new ArrayList<>();
    for(int i:map.keySet())
    {
        if(map.get(i)==0)
            result.add(i);
    }
    return result;
}


    public static void main(String[] args) {
        int[] nums=new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
        //findDisappearedNumbers(nums);
    }
}
