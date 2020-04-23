package thread.questions;

/**
 * @author 谭春
 * Date: 2020/3/31
 * Description:
 */
public class a {
    public static void main(String[] args) {
        String a= "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab" + "c";
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        System.out.println(c==d);

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {

        if (left < right) {
            int division = division(nums, left, right);
            quickSort(nums, left, division - 1);
            quickSort(nums, division + 1, right);
        }
    }

    public int division(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];

        }
        nums[left] = temp;
        return left;
    }


}

