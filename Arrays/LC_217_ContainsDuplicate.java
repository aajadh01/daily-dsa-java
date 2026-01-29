/*
LeetCode: 217
Problem: Contains Duplicate
Link: https://leetcode.com/problems/contains-duplicate/

Approach Used: HashSet

Step-by-Step Explanation:

1. Create an empty HashSet to store elements seen so far.
2. Traverse the array element by element.
3. Try to add each element to the set.
4. If adding fails, it means the element already exists → duplicate found.
5. If the loop completes without finding duplicates, return false.

Example:
Input: nums = [1, 2, 3, 1]

Traversal:
- Add 1 → success
- Add 2 → success
- Add 3 → success
- Add 1 → already exists → duplicate found

Output: true

Why This Works:
A HashSet does not allow duplicate elements.
Insertion and lookup are both O(1) on average.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;

        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
