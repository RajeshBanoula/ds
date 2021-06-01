package my.ds.problems;
/*
https://leetcode.com/problems/richest-customer-wealth/
*/

public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int maxWealth=0;
        int sum=0;
        for(int i =0; i<accounts.length; i++){
            sum=0;
            for(int j=0; j<accounts[i].length ;j++){
                sum+=accounts[i][j];
            }
            if(maxWealth<sum){
                maxWealth=sum;
            }
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
        System.out.println(maximumWealth(new int[][]{{1,5},{7,3},{3,5}}));
    }
}
