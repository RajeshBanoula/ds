package my.ds.problems;

public class MissingFirstPositiveNumber {

    public static int firstMissingPositive(int[] nums) {
        if(nums.length==0)
            return 1;
        int t[] = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i]-1<nums.length && nums[i]>0){
                t[nums[i]-1] = 1;
            }
        }

        for(int i=0; i<t.length; i++){
            if(t[i]==0){
                return i+1;
            }
        }
        return t.length+1;
    }

    public static void main(String[] args) {
        int[] a = {-1,1,5};
        System.out.println(firstMissingPositive(a));
    }
}
