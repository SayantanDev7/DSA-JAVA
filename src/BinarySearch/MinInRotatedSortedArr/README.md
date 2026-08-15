
# **LeetCode 153 — Find Minimum in Rotated Sorted Array**

---

## 📌 1. Understand Problem

Given a sorted array of unique integers that has been rotated at an unknown pivot, find the minimum element in **$O(\log n)$** time complexity.

```text
Original: [1, 2, 3, 4, 5, 6, 7]
Rotated:  [4, 5, 6, 7, 1, 2, 3]

Input:  nums = [4, 5, 6, 7, 1, 2, 3]
Output: 1

```





## 🐢 2. Naive Approach

* **Idea:** Iterate through the array linearly and maintain the minimum element seen so far.
* **Code:**

```java
int min = nums[0];
for (int i = 1; i < nums.length; i++) {
    min = Math.min(min, nums[i]);
}

```

* **Limitation:** Takes $O(n)$ time complexity, which violates the strict $O(\log n)$ problem requirement.

---

## ⚡ 3. Optimize (Binary Search on Rotation Point)

* **Core Insight:** The array has a single inflection/rotation point where the drop occurs. The minimum element lies precisely at or immediately after this rotation point.
* **Strategy:**

1. Calculate `mid = left + (right - left) / 2`.
2. Compare `nums[mid]` against `nums[right]`:
* **If `nums[mid] > nums[right]`:** The pivot/minimum lies strictly in the right half $\rightarrow$ `left = mid + 1`.
* **If `nums[mid] < nums[right]`:** The right half is sorted; the minimum is either at `mid` or to its left $\rightarrow$ `right = mid` *(we do not use `mid - 1` because `nums[mid]` itself could be the minimum)*.



```text
                        Find mid
                           |
             ┌─────────────┴─────────────┐
             ▼                           ▼
   nums[mid] > nums[right]     nums[mid] < nums[right]
   [ Minimum in RIGHT Half ]   [ Minimum at MID or LEFT ]
             │                           │
             ▼                           ▼
        left = mid + 1              right = mid

```

---

## 🧪 4. Dry Run

```text
Input: nums = [5, 6, 7, 8, 9, 1, 2, 3, 4]
Initial: left = 0, right = 8 -> mid = 4 (nums[mid] = 9, nums[right] = 4)

1. Step 1: 9 > 4 -> Minimum is in right half.
   Update: left = mid + 1 = 5 -> Search space: [1, 2, 3, 4] (indices 5..8).

2. Step 2: mid = 6 (nums[6] = 2, nums[8] = 4).
   2 < 4 -> Minimum could be at mid or left.
   Update: right = mid = 6 -> Search space: [1, 2] (indices 5..6).

3. Step 3: mid = 5 (nums[5] = 1, nums[6] = 2).
   1 < 2 -> Update: right = mid = 5.

4. Termination: left == right == 5.
   Result: nums[5] = 1.

```

---

## 📊 5. Complexity Analysis

| Metric | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity (TC)** | **$O(\log n)$** | Halves the active search space in every iteration. |
| **Auxiliary Space (SC)** | **$O(1)$** | Operates in-place using only pointers (`left`, `right`, `mid`). |

---

```

```
