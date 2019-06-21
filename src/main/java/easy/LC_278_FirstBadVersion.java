package easy;

/*
Difficulty: Easy
Companies: Facebook

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest
version of your product fails the quality check. Since each version is developed based on the previous version,
all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function
to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
 */
public class LC_278_FirstBadVersion {  //extends VersionControl

    /**
     * The main idea of this question is to implement a binary search to minimize number of calls
     * Q: Is n always bigger than 0, what should we return if 0 comes or minus values?
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int lo = 0;
        int hi = n;
        int mid = -1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if(isBadVersion(mid) == true) {  //Search before
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }


    /* The isBadVersion API is defined in the parent class VersionControl.*/
    boolean isBadVersion(int version) {
        return true;
    }
}
