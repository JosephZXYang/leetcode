/**

Key points:

1. The idea is: Split both arrays into 2 subarrays. 
Suppose nums1 = nums1_left + nums1_right,
        nums2 = nums2_left + nums2_right,
make sure that (nums1_left + nums2_left) contains half
numbers, and no number in this set can be larger than the smallest
number in the remaining set. This condition can be represented as:
    a) i + j = (m + n) / 2       // (m + n) even case
             = (m + n) / 2 - 1   // (m + n) odd case
    b) nums1[i] <= nums2[j + 1]
    c) nums2[j] <= nums1[i + 1]

2. Use binary search when we trying to find the corrent i/j split.
In this case, we could accomplish O(log n) time complexity.

*/

import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // make sure that nums1 is the shorter array
        if (m > n) { 
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        
        // initialization
        int iMin = 0, iMax = m, half = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = half - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; 
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; 
            }
            else { 
                int maxLeft = 0;
                if (i == 0) { 
                    maxLeft = nums2[j-1]; 
                }
                else if (j == 0) { 
                    maxLeft = nums1[i-1]; 
                }
                else { 
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]); 
                }
                if ( (m + n) % 2 == 1 ) { 
                    return maxLeft; 
                }
                else {
                    int minRight = 0;
                    if (i == m) { 
                        minRight = nums2[j]; 
                    }
                    else if (j == n) { 
                        minRight = nums1[i]; 
                    }
                    else { 
                        minRight = Math.min(nums1[i], nums2[j]); 
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }
        }
        return 0.0;
    }
}