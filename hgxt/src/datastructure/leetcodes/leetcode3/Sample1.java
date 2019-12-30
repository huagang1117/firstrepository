package datastructure.leetcodes.leetcode3;

import java.util.HashSet;
import java.util.Set;

public class Sample1 {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                System.out.println("加"+set);
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
                System.out.println("删"+set);
            }
        }
        System.out.println("最后"+set);
        return ans;
    }

    public static void main(String[] args){
        String s = "abcceadf";
        System.out.println(Sample1.lengthOfLongestSubstring(s));
    }
}
