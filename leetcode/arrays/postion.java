class postion {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { // Use i < nums.length to avoid out-of-bounds error
            if (nums[i] >= target) { // If target is found or nums[i] is larger, return the index
                return i;
            }
        }
        // If target is greater than all elements, return the last index + 1
        return nums.length;
    }
}