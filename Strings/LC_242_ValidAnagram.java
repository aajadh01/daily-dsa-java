/*
LeetCode: 242
Problem: Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/

Approach Used: Frequency Count (Character Array)

Step-by-Step Explanation:

1. If the lengths of both strings are different, they cannot be anagrams.
2. Create an integer array of size 26 to store character frequencies.
3. Traverse the first string and increment the count for each character.
4. Traverse the second string and decrement the count for each character.
5. If at any point a character count becomes negative, return false.
6. If all counts balance correctly, return true.

Example:
Input:
s = "anagram"
t = "nagaram"

Frequency count after first string:
a:3, n:1, g:1, r:1, m:1

After processing second string, all counts return to zero.

Output: true

Why This Works:
Anagrams contain the same characters with the same frequencies.

Time Complexity: O(n)
Space Complexity: O(1)  (constant space for 26 letters)
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (freq[index] > 0) {
                freq[index]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
