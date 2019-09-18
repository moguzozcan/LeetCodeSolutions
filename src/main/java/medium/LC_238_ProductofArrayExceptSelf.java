package medium;

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the
product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the
purpose of space complexity analysis.)
 */

public class LC_238_ProductofArrayExceptSelf {

    /**
     * Looking at the figure about we can figure another way of computing those different product values.
     *
     * Instead of dividing the product of all the numbers in the array by the number at a given index to get
     * the corresponding product, we can make use of the product of all the numbers to the left and all the
     * numbers to the right of the index. Multiplying these two individual products would give us the desired
     * result as well.
     *
     * For every given index, ii, we will make use of the product of all the numbers to the left of it and
     * multiply it by the product of all the numbers to the right. This will give us the product of all the
     * numbers except the one at the given index ii. Let's look at a formal algorithm describing this idea
     * more concretely.
     *
     * Algorithm
     *
     * Initialize two empty arrays, L and R where for a given index i, L[i] would contain the product of all
     * the numbers to the left of i and R[i] would contain the product of all the numbers to the right of i.
     * We would need two different loops to fill in values for the two arrays. For the array L, L[0]L[0] would be
     * 1 since there are no elements to the left of the first element. For the rest of the elements, we simply
     * use L[i] = L[i - 1] * nums[i - 1]L[i]=L[i−1]∗nums[i−1]. Remember that L[i] represents product of all
     * the elements to the left of element at index i.
     * For the other array, we do the same thing but in reverse i.e. we start with the initial value of 1 in
     * R[length - 1]R[length−1] where lengthlength is the number of elements in the array, and keep updating
     * R[i] in reverse. Essentially, R[i] = R[i + 1] * nums[i + 1]R[i]=R[i+1]∗nums[i+1]. Remember that R[i]
     * represents product of all the elements to the right of element at index i.
     * Once we have the two arrays set up properly, we simply iterate over the input array one element at a
     * time, and for each element at index i, we find the product except self as L[i] * R[i]L[i]∗R[i].
     * Let's go over a simple run of the algorithm that clearly depicts the construction of the two intermediate
     * arrays and finally the answer array.
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // The length of the input array
        int length = nums.length;

        // The left and right arrays as described in the algorithm
        int[] L = new int[length];
        int[] R = new int[length];

        // Final answer array to be returned
        int[] answer = new int[length];

        // L[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so L[0] would be 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {

            // L[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R[length - 1] would be 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {

            // R[i + 1] already contains the product of elements to the right of 'i + 1'
            // Simply multiplying it with nums[i + 1] would give the product of all
            // elements to the right of index 'i'
            R[i] = nums[i + 1] * R[i + 1];
        }

        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            answer[i] = L[i] * R[i];
        }

        return answer;
    }

    /**
     * Approach 2: O(1) space approach
     * Although the above solution is good enough to solve the problem since we are not using division anymore, there's a follow-up component as well which asks us to solve this using constant space. Understandably so, the output array does not count towards the space complexity. This approach is essentially an extension of the approach above. Basically, we will be using the output array as one of L or R and we will be constructing the other one on the fly. Let's look at the algorithm based on this idea.
     *
     * Algorithm
     *
     * Initialize the empty answer array where for a given index i, answer[i] would contain the product of all the numbers to the left of i.
     * We construct the answer array the same way we constructed the L array in the previous approach. These two algorithms are exactly the same except that we are trying to save up on space.
     * The only change in this approach is that we don't explicitly build the R array from before. Instead, we simply use a variable to keep track of the running product of elements to the right and we keep updating the answer array by doing answer[i] = answer[i] * Ranswer[i]=answer[i]∗R. For a given index i, answer[i] contains the product of all the elements to the left and R would contain product of all the elements to the right. We then update R as R = R * nums[i]R=R∗nums[i]
     * @param nums
     * @return
     */
    public int[] productExceptSelfO1Space(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}
