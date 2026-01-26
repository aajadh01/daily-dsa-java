/*
LeetCode: 28
Problem: Find the Index of the First Occurrence in a String (strStr)
Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

Approach Used: Naive String Matching

Step-by-Step Explanation:

1. Traverse the main string (haystack) character by character.
2. Maintain a pointer 'k' for the pattern (needle).
3. If characters match, move both pointers forward.
4. If all characters of the pattern are matched (k == needle length),
   return the starting index of the match.
5. On mismatch:
   - Reset the pattern pointer to 0
   - Move the main string pointer back to the next possible start
6. Continue until the haystack is fully traversed.

Example:
haystack = "hello"
needle = "ll"

Traversal:
- Compare h vs l → mismatch
- Compare e vs l → mismatch
- Compare l vs l → match
- Compare next l vs l → match → full pattern matched

Output: 2

Why This Works:
The algorithm checks every possible starting position in the haystack
where the needle could begin.

Limitation:
This approach has O(n * m) time complexity in the worst case.
For large strings, a more efficient algorithm like KMP is preferred.

Time Complexity: O(n * m)
Space Complexity: O(1)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int k = 0;

        for (int i = 0; i < n; i++) {
            if (haystack.charAt(i) == needle.charAt(k)) {
                k++;
                if (k == m) {
                    return i - k + 1;
                }
            } else {
                i = i - k;
                k = 0;
            }
        }
        return -1;
    }
}
