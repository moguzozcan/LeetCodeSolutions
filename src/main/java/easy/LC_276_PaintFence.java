package easy;/*
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Input: n = 3, k = 2
Output: 6
Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

            post1  post2  post3
 -----      -----  -----  -----
   1         c1     c1     c2
   2         c1     c2     c1
   3         c1     c2     c2
   4         c2     c1     c1
   5         c2     c1     c2
   6         c2     c2     c1

   Mistake Analysis:

Fail to thoroughly understand problem!!! The problem asks us to compute the number of ways for arranging the painting which has no more than two sussive post share the same color. It means we were allowed to make two neighboring posts share the same color!
Analysis:

The problem of asking how many ways to do something is usually very easy!
And it could always be solved through dynamic programming. You just need to carefully design the transitional function acoording to characteristics or certain restrictions.

We know for each post, it could differ or same as its previous post's color.
Assume:
differ_count: represents the current post with different color with its previous post(the painting ways)
same_count: represents the current post share the same color with its previous post(the painiting ways)

We could have following transition function
differ_count(i) = differ_count(i-1) * (k-1) + same_count(i-1) * (k-1)
same_count(i) = differ_count(i-1) //cause the current post must have the same color with post i-1, thus we could only use the way that differ_count(i-1)

Base case:
2 is a perfect base case for use to start, since it has simple same_count and differ_count;
https://www.cnblogs.com/airwindow/p/4796688.html


----------
https://www.programcreek.com/2014/05/leetcode-pain-fence-java/
The key to solve this problem is finding this relation.

f(n) = (k-1)(f(n-1)+f(n-2))

Assuming there are 3 posts, if the first one and the second one has the same color, then the third one has k-1 options. The first and second together has k options.
If the first and the second do not have same color, the total is k * (k-1), then the third one has k options. Therefore, f(3) = (k-1)*k + k*(k-1)*k = (k-1)(k+k*k)

--------
http://buttercola.blogspot.com/2015/09/leetcode-paint-fence.html
Understand the problem:
We can use a DP solution.
  -- Define two DP arrays, diff[n] and same[i]. Where diff[i] means the number of ways for the fence i which has different color with fence i -1. same[i] means the number of ways if fence i has the same color with fence i - 1.
 --  Initialization same[0] = 0, diff[0] = k.
 -- same[i] = diff[i - 1].
 -- diff[i] = (k - 1) * (same[i - 1] + diff[i - 1]);

 -- Final state: same[n - 1] + diff[n - 1].

 */

public class LC_276_PaintFence {

    public int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        if (n == 1)
            return k;
        int same_count = k;
        int differ_count = k * (k - 1);
        for (int i = 3; i <= n; i++) {
            int temp = differ_count;
            differ_count = differ_count * (k - 1) + same_count * (k - 1);
            same_count = temp;
        }
        return same_count + differ_count;
    }
}

/*
public int numWays(int n, int k) {
    int dp[] = {0, k , k*k, 0};

    if(n <= 2)
        return dp[n];

    for(int i = 2; i < n; i++){
        dp[3] = (k - 1) * (dp[1] + dp[2]);
        dp[1] = dp[2];
        dp[2] = dp[3];
    }

    return dp[3];
}

public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        // i -1 and i -2 with the same color
        int[] dp1 = new int[n];
        // i - 1 and i - 2 with diff. color
        int[] dp2 = new int[n];

        // Initializaiton
        dp1[0] = 0;
        dp2[0] = k;

        for (int i = 1; i < n; i++) {
            dp1[i] = dp2[i - 1];
            dp2[i] = (k - 1) * (dp1[i - 1] + dp2[i - 1]);
        }

        // Final state
        return dp1[n - 1] + dp2[n - 1];
    }


    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        int preSame = 0;
        int preDiff = k;

        for (int i = 1; i < n; i++) {
            int same = preDiff;
            int diff = (k - 1) * (preSame + preDiff);

            preSame = same;
            preDiff = diff;
        }

        return preSame + preDiff;
    }
 */
