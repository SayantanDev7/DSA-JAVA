


# **LeetCode 33 — Search in Rotated Sorted Array**

---

## 📌 1. Understand Problem
Given a sorted array of unique integers that has been rotated at an unknown pivot, find the target value's index in **$O(\log n)$** time complexity. Return `-1` if the target is not present.


Original: [1, 2, 3, 4, 5, 6, 7]
Rotated:  [4, 5, 6, 7, 1, 2, 3]

Input:  nums = [4, 5, 6, 7, 1, 2, 3], target = 2
Output: 5



---

## 🐢 2. Naive Approach

* **Idea:** Iterate through the array linearly from start to end and check each element.
* **Limitation:** Takes $O(n)$ time complexity, which violates the strict $O(\log n)$ problem requirement.

---

## ⚡ 3. Optimize (Binary Search on Rotated Array)

* **Core Insight:** In a rotated sorted array, splitting at any `mid` will **always leave at least one half strictly sorted**.
* **Strategy:**
1. Calculate `mid = left + (right - left) / 2`.
2. Identify which half is sorted:
* If `nums[mid] > nums[right]` $\rightarrow$ **Left half is sorted**.
* If `nums[mid] <= nums[right]` $\rightarrow$ **Right half is sorted**.


3. Check whether `target` falls inside the sorted half's boundaries:
* **Inside sorted half:** Narrow search to this half.
* **Outside sorted half:** Discard this half and search the other side.





```text
                        Find mid
                           |
             ┌─────────────┴─────────────┐
             ▼                           ▼
    nums[mid] > nums[right]     nums[mid] <= nums[right]
    [ LEFT Half is Sorted ]     [ RIGHT Half is Sorted ]
             │                           │
    Is target in range?         Is target in range?
(nums[left] <= T < nums[mid])  (nums[mid] < T <= nums[right])
        ┌────┴────┐                 ┌────┴────┐
       YES        NO               YES        NO
        ▼         ▼                 ▼         ▼
    right=mid-1  left=mid+1     left=mid+1   right=mid-1

```

---

## 🧪 4. Dry Run

### Case A: Left Half Sorted

```text
nums = [5, 6, 7, 8, 9, 1, 2, 3, 4], target = 2
Initial: left = 0, right = 8 -> mid = 4 (nums[mid] = 9, nums[right] = 4)

1. nums[mid] > nums[right] (9 > 4) -> Left half [5..9] is sorted.
2. Check range: 5 <= 2 < 9         -> False. Target is in the right half.
3. Update: left = mid + 1 = 5      -> New range: [1, 2, 3, 4].
4. Next mid = 6 (nums[6] = 2)      -> Target found! Return index 6.

```

### Case B: Right Half Sorted

```text
nums = [9, 1, 2, 3, 4, 5, 6, 7, 8], target = 2
Initial: left = 0, right = 8 -> mid = 4 (nums[mid] = 4, nums[right] = 8)

1. nums[mid] <= nums[right] (4 < 8) -> Right half [4..8] is sorted.
2. Check range: 4 < 2 <= 8          -> False. Target is in the left half.
3. Update: right = mid - 1 = 3      -> New range: [9, 1, 2, 3].
4. Continue binary search until target index 2 is found.

```

---


---

## 📊 6. Complexity Analysis

| Metric | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity (TC)** | **$O(\log n)$** | Halves the active search space in every iteration. |
| **Auxiliary Space (SC)** | **$O(1)$** | Operates in-place with constant auxiliary pointers (`left`, `right`, `mid`). |

---


```

```
