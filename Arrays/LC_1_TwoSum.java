/*
LeetCode: 1
Problem: Two Sum
Link: https://leetcode.com/problems/two-sum/

Initial Thought (Brute Force):
I checked every possible pair of elements and returned the indices
when their sum matched the target.

Why This Works:
Trying all pairs guarantees finding the correct answer if it exists.

Limitation:
This approach uses two nested loops, leading to O(n^2) time complexity,
which is inefficient for large inputs.

Better Approach (Learning):
Using a HashMap can reduce the time complexity to O(n) by storing
previously seen elements and checking complements.

Algorithm (Brute Force):
1. Loop through the array using index i
2. For each i, loop through remaining elements using index j
3. If nums[i] + nums[j] == target, return indices

Time Complexity: O(n^2)
Space Complexity: O(1)

Edge Cases:
- Exactly one valid answer exists
- Negative numbers
- Array size = 2
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}
