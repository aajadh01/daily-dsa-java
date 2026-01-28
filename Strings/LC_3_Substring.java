/*
LeetCode: 3
Problem: Longest Substring Without Repeating Characters
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Approach Used: Sliding Window with Last Seen Index

Step-by-Step Explanation:

1. Use an array of size 256 to store the last seen position of characters.
   (Supports all ASCII characters)

2. Maintain a sliding window using two pointers:
   - 'low' represents the start of the window
   - 'i' represents the end of the window

3. Traverse the string character by character.

4. For each character:
   - If it was seen before and its last seen position is inside
     the current window, move 'low' to the next position
     after the previous occurrence.

5. Update the last seen position of the current character.

6. Calculate the window length and update the maximum length.

Example:
Input: s = "abcabcbb"

Traversal:
i=0 → 'a' → window = "a" → max = 1  
i=1 → 'b' → window = "ab" → max = 2  
i=2 → 'c' → window = "abc" → max = 3  
i=3 → 'a' (repeat) → move low to index after previous 'a'  
window = "bca"

Output: 3

Why This Works:
The window always contains unique characters.
Instead of shrinking one step at a time, we jump the window start
using stored indices, ensuring linear time complexity.

Time Complexity: O(n)
Space Complexity: O(1)  (constant space for ASCII characters)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[256];
        int low = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);

            if (lastSeen[ch] > 0 && lastSeen[ch] - 1 >= low) {
                low = lastSeen[ch];
            }

            lastSeen[ch] = i + 1;
            maxLen = Math.max(maxLen, i - low + 1);
        }
        return maxLen;
    }
}
