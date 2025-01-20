public class IntersectionOfTwo {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    temp[index++] = nums1[i];
                    nums2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }

        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        // Create an object of the class
        IntersectionOfTwo solution = new IntersectionOfTwo();

        // Call the intersect method
        int[] result = solution.intersect(nums1, nums2);

        // Print the result array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
// public static void main(String[] args) {
// int[] nums1 = {1, 2, 2, 1}; // Correct syntax for array initialization
// int[] nums2 = {2, 2};
// for(int i : nums1){
// System.out.println(i);
// } // Correct syntax for array initialization

// // // Create an object of the class to call the non-static method
// // IntersectionOfTwo solution = new IntersectionOfTwo();
// // int[] result = solution.intersect(nums1, nums2);

// // Print the result array
// // for (int num : result) {
// // System.out.print(num + " ");
// // }
// }
// }