import java.util.HashSet;

class removeduplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> uniqueNums = new HashSet<>();
        int i = 0;
        int totalSum = 0;

        for (int num : nums) {
            if (uniqueNums.add(num)) {
                nums[i++] = num;
                totalSum += num;
            }
        }

        return i;
    }
}
