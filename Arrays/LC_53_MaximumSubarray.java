/*
LeetCode: 53
Problem: Maximum Subarray
Link: https://leetcode.com/problems/maximum-subarray/

Approach Used: Two Pointer (Learning Attempt)

Step-by-Step Explanation:

1. Initialize two pointers:
   - left = 0
   - right = last index of the array

2. Treat the subarray between left and right as the current window.

3. Compute the sum of all elements in this window.

4. Store this sum as the maximum sum seen so far.

5. At each step, decide which side to shrink:
   - Compare removing the left element vs removing the right element.
   - Remove the element whose removal decreases the sum less.

6. Move the corresponding pointer inward and update the window sum.

7. Continue shrinking until both pointers meet.

Example:
Input: nums = [-2, 1, -3, 4, -1, 2, 1]

Initial window:
left = 0, right = 6
sum = 2

Remove -2 from left:
New window = [1, -3, 4, -1, 2, 1]
sum = 4

The process continues while tracking the maximum sum.

Important Note:
This approach is NOT guaranteed to work for all test cases because
the maximum subarray can exist entirely inside the array and may
not include the edges.

Status:
This is a non-optimal learning approach.
The optimal solution (Kadane’s Algorithm) will be added later.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int max = sum;

        while (left < right) {
            max = Math.max(max, sum);

            if (sum - nums[left] > sum - nums[right]) {
                sum -= nums[left];
                left++;
            } else {
                sum -= nums[right];
                right--;
            }
        }

        return max;
    }
}
