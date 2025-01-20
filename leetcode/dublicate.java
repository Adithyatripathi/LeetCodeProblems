import java.util.HashMap;

public class dublicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Initialize a HashMap to store numbers and their indices

        for (int i = 0; i < nums.length; i++) { // Loop through the array
            if (!map.containsKey(nums[i])) { // If the number is not in the map
                map.put(nums[i], i); // Add the number with its index to the map
            } else { // If the number is already in the map
                int prevIndex = map.get(nums[i]); // Get the previously stored index of this number
                if (Math.abs(prevIndex - i) <= k) { // Check if the difference between indices is less than or equal to
                                                    // k
                    return true; // If yes, return true as we found such a duplicate
                } else {
                    map.put(nums[i], i); // Update the index of this number to the current index
                }
            }
        }
        return false; // Return false if no such duplicate is found
    }
}
