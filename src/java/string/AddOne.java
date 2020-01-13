package string;

public class AddOne {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }

    public static void main(String[] args) {
        int[] a={1,2,3};
        AddOne addOne = new AddOne();
        System.out.println(addOne.plusOne(a));
    }
}
