/*
LeetCode: 344
Problem: Reverse String
Link: https://leetcode.com/problems/reverse-string/

Approach Used: Two Pointer

Step-by-Step Explanation:

1. Initialize two pointers:
   - left at the start of the array
   - right at the end of the array

2. While left is less than right:
   - Swap the characters at left and right
   - Move left forward
   - Move right backward

3. Continue until both pointers meet.

Example:
Input: s = ['h','e','l','l','o']

Step 1:
left = 0, right = 4 → swap 'h' and 'o'
Array becomes: ['o','e','l','l','h']

Step 2:
left = 1, right = 3 → swap 'e' and 'l'
Array becomes: ['o','l','l','e','h']

Stop when left >= right.

Output: ['o','l','l','e','h']

Why This Works:
Swapping from both ends reverses the array in-place
without using extra memory.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
