LeetCode 153 — Find Minimum in Rotated Sorted Array
Understand Problem

Given a sorted array of unique elements that has been rotated, find the minimum element.

Example:

Original: [1,2,3,4,5,6,7]
Rotated:  [4,5,6,7,1,2,3]


Answer = 1

The goal is to solve it in O(log n).

Naive Approach

Traverse the entire array and keep track of the minimum:

int min = nums[0];


for(int i = 1; i < nums.length; i++){
min = Math.min(min, nums[i]);
}
Complexity
TC → O(n)
SC → O(1)

This works, but doesn't satisfy the required O(log n) time.

Optimize Logic

Use Binary Search.

The key observation:

The array has only one rotation point, and the minimum is exactly at/after this point.

At every step, compare:

nums[mid] > nums[right]
Case 1: nums[mid] > nums[right]

Example:

[5,6,7,8,9,1,2,3,4]
↑       ↑
mid    right
9       4

Since:

9 > 4

the rotation point/minimum must be to the right of mid.

left = mid + 1;
Case 2: nums[mid] < nums[right]

Example:

[9,1,2,3,4,5,6,7,8]
↑       ↑
mid    right
4       8

Since:

4 < 8

the right half is normally sorted.

The minimum could be at mid or somewhere to its left.

Therefore:

right = mid;

⚠️ We use mid, not mid - 1, because nums[mid] itself could be the minimum.

Dry Run
Input
nums = [5,6,7,8,9,1,2,3,4]
Step 1
left = 0
right = 8
mid = 4


nums[mid] = 9
nums[right] = 4
9 > 4

Therefore:

left = mid + 1 = 5

Search space:

[1,2,3,4]
↑     ↑
left  right
Step 2
left = 5
right = 8
mid = 6


nums[mid] = 2
nums[right] = 4
2 < 4

Therefore:

right = mid = 6

Search space:

[1,2]
↑   ↑
left right
Step 3
left = 5
right = 6
mid = 5


nums[mid] = 1
nums[right] = 2
1 < 2

Therefore:

right = mid = 5

Now:

left = 5
right = 5

Stop.

nums[left] = 1
Answer:
1
TC & SC
Time Complexity

Each iteration eliminates roughly half of the search space.

O(log n)
Auxiliary Space

Only left, right, and mid are used.

O(1)