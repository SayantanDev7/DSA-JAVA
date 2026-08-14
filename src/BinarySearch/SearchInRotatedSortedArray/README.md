# LeetCode 33 — Search in Rotated Sorted Array

## 📌 Problem Overview
Given a sorted array of unique integers rotated at an unknown pivot, find the index of target in **O(log n)** runtime. Return -1 if target not found.

Original: [1, 2, 3, 4, 5, 6, 7]
Rotated:  [4, 5, 6, 7, 1, 2, 3]

Input:  nums = [4, 5, 6, 7, 1, 2, 3], target = 2
Output: 5

Core Insight
In a rotated sorted array, at least one half (left or right) is always sorted around mid.

Instead of comparing target directly against nums[mid], we:

1.Identify the sorted half.

2.Check if target falls within the bounds of that sorted half.

3.Discard the irrelevant half and repeat.

Dry Run Examples
Example 1: Left Half Sorted

nums = [5, 6, 7, 8, 9, 1, 2, 3, 4], target = 2
L=0, R=8, mid=4 (nums[mid]=9, nums[R]=4)

1. nums[mid] > nums[R] (9 > 4)  → Left half [5..9] is sorted.
2. Check range: 5 <= 2 < 9       → False. Target is in right half.
3. Update: L = mid + 1 = 5       → New range: [1, 2, 3, 4].
4. Next mid=6 (nums[6]=2)        → Target found! Return 6.

Example 2: Right Half Sorted

nums = [9, 1, 2, 3, 4, 5, 6, 7, 8], target = 2
L=0, R=8, mid=4 (nums[mid]=4, nums[R]=8)

1. nums[mid] <= nums[R] (4 < 8) → Right half [4..8] is sorted.
2. Check range: 4 < 2 <= 8       → False. Target is in left half.
3. Update: R = mid - 1 = 3       → New range: [9, 1, 2, 3].
4. Continue binary search until target index 2 is found.

Complextiy :-

Time, -> O(logn),Halves the active search space in each iteration.
Space,O(1),Operates in-place with constant extra pointers.




