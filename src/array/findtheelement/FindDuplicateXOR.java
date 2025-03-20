package array.findtheelement;
public class FindDuplicateXOR {
    public static int findDuplicate(int[] nums) {
        int xorAll = 0;
        int n = nums.length - 1; // Since numbers can be from 1 to n

        // XOR all elements in the array
        for (int num : nums) {
            xorAll ^= num;
        }

        // XOR with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        return xorAll; // The duplicate number
    }

    public static void main(String[] args) {
        int[] nums = {1, 2}; // Example input
        System.out.println("Duplicate number: " + findDuplicate(nums));
    }
}
