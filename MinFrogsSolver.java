/*
Croaking Frogs
You are given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs. Multiple frogs can croak at the same time, so multiple "croak" sounds are mixed together.

Your task is to determine the minimum number of different frogs required to produce all the croaks in the given string.

Rules & Constraints:

A valid "croak" means a frog prints the five letters 'c', 'r', 'o', 'a', and 'k' sequentially, and must print all five letters to finish a croak.
The input string croakOfFrogs contains only the characters 'c', 'r', 'o', 'a', and 'k'.
The frogs can croak concurrently (at the same time).

If the given string is not a combination of valid "croak" sounds, return -1.

Example 1:

Input: croakOfFrogs = "croakcroak"

Output: 1

Explanation: Only one frog is sufficient to produce the entire "croakcroak" sequence.

Example 2:

Input: croakOfFrogs = "crcoakroak"
Output: 2
Explanation: The minimum number of frogs required is 2 because the 'c' and 'r' of the second "croak" appear before the 'k' of the first "croak".

Example 3:

Input: croakOfFrogs = "croakcrook"
Output: -1
Explanation: The string contains an invalid letter 'o' after 'k', so it's not a combination of valid "croak" sounds. Return -1.

Example 4:

Input: croakOfFrogs = "croakcroa"
Output: -1
Explanation: The string is not complete "croak" sounds. Return -1.
*/


public class MinFrogsSolver {

    public int minNumberOfFrogs(String croakOfFrogs) {

        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int currentFrogs = 0;
        int frogCount = 0;
        char arr[] = croakOfFrogs.toCharArray();

        for (char ch : arr) {

            if (ch == 'c') {
                c++;
                currentFrogs++;
                if (currentFrogs > frogCount) {
                    frogCount = currentFrogs;
                }
            } else if (ch == 'r') {
                if (c == 0)
                    return -1;
                c--;
                r++;
            } else if (ch == 'o') {
                if (r == 0)
                    return -1;
                r--;
                o++;
            } else if (ch == 'a') {
                if (o == 0)
                    return -1;
                o--;
                a++;
            } else if (ch == 'k') {
                if (a == 0)
                    return -1;
                a--;
                currentFrogs--;
            } else {
                return -1;
            }

        }
        if (c != 0 || r != 0 || o != 0 || a != 0 || k != 0) {
            return -1;
        }

        return frogCount;

    }

    public static void main(String[] args) {
        MinFrogsSolver m = new MinFrogsSolver();
        int res1 = m.minNumberOfFrogs("croakcroak");
        int res2 = m.minNumberOfFrogs("crcoakroak");
        int res3 = m.minNumberOfFrogs("croakcrook");
        int res4 = m.minNumberOfFrogs("croakcroa");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);

    }
}
