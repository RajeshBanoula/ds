package my.ds.problems;

/*
https://leetcode.com/problems/check-if-the-sentence-is-pangram/
*/

import java.util.HashSet;
import java.util.Set;

public class CheckIfPangram {


    public static boolean checkIfPangram(String sentence) {

        Set<Integer> c = new HashSet<Integer>();
        for(int i=97;i<97+26;i++){
            c.add(i);
        }

        for(char ch : sentence.toCharArray()){
            c.remove((int)ch);
            if(c.size()==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));

    }
}
