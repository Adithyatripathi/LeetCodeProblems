class majorityEle {
    public int majorityElement(int[] nums) {
        int maj = nums[0], vote = 1;
        for (int i = 0; i <= nums.length; i++) {
            if (vote == 0) {// this is to chwck thats the vote is not 0
                vote++;
                maj = nums[i];// if its 0 make the maj as the current val
            } else if (vote == nums[i]) {// if the before num and now number is same
                vote++;// if same na it has 2
            } else {
                vote--;
            }

        }
        return maj;
    }
}
