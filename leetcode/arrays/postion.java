class postion {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] = target) { 
             return i;
                break;
            }
        }
      
        return -1;
    }
}
