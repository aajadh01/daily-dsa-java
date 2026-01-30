/*
LeetCode: 1
Problem: Two Sum
Link: https://leetcode.com/problems/two-sum/

----------------------------------------
Approach 1: Brute Force
----------------------------------------

Idea:
Check all possible pairs using two nested loops.

Time Complexity: O(n^2)
Space Complexity: O(1)

----------------------------------------
Approach 2: HashMap (Optimized)
----------------------------------------

Idea:
Store previously seen numbers in a HashMap.
For each element, check if its complement (target - current value)
already exists in the map.

If it exists, we have found the required pair.

Step-by-Step Explanation:

1. Create an empty HashMap to store number → index.
2. Traverse the array.
3. For each element, compute complement = target - nums[i].
4. If complement exists in the map, return its index and current index.
5. Otherwise, store nums[i] with its index in the map.

Example:
nums = [2, 7, 11, 15], target = 9

i = 0 → complement = 7 → not in map → store (2 → 0)
i = 1 → complement = 2 → found in map → return [0, 1]

Why This Works:
The HashMap allows constant-time lookup of previously seen values.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
