/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j])
where the two words do not share common letters. If no such two words exist, return 0.

Example 1:
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".

Example 3:
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.

Constraints: 
 2 <= words.length <= 1000 
 1 <= words[i].length <= 1000 
 words[i] consists only of lowercase English letters
*/

import java.util.ArrayList;

public class MaximumProductOfLength {

    public int solve(ArrayList<String> words) {
        int maxLength = 0;

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (!(isCharPresent(words.get(i), words.get(j)))) {
                    int prod = words.get(i).length() * words.get(j).length();
                    maxLength = Math.max(maxLength, prod);
                }
            }
        }
        return maxLength;
    }

    boolean isCharPresent(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (s2.contains(ch + "")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("abcw");
        words.add("baz");
        words.add("foo");
        words.add("bar");
        words.add("xtfn");
        words.add("abcdef");

        ArrayList<String> words1 = new ArrayList<>();
        words1.add("a");
        words1.add("ab");
        words1.add("abc");
        words1.add("d");
        words1.add("cd");
        words1.add("bcd");
        words1.add("abcd");

        ArrayList<String> words2 = new ArrayList<>();
        words2.add("a");
        words2.add("aa");
        words2.add("aaa");
        words2.add("aaaa");

        ArrayList<String> words3 = new ArrayList<>();
        words3.add("abc");
        words3.add("def");
        words3.add("ghij");
        words3.add("ad");
        words3.add("xyz");

        ArrayList<String> words4 = new ArrayList<>();
        words.add("aa");
        words.add("aaa");
        words.add("aaaaa");
        words.add("aaaaaa");

        MaximumProductOfLength m = new MaximumProductOfLength();

        System.out.println("Case 1 result: " + m.solve(words));
        System.out.println("Case 2 result: " + m.solve(words1));
        System.out.println("Case 3 result: " + m.solve(words2));
        System.out.println("Case 4 result: " + m.solve(words3));
        System.out.println("Case 5 result: " + m.solve(words4));

    }
}