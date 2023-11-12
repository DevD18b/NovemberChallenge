public class problem3 {
    public static int minimumOperationToMaximizeLastElement(int[] arr1, int[] arr2) {

        int last1 = arr1[arr1.length - 1];
        int last2 = arr2[arr2.length - 1];
        int res = 0;
        int cannot = 1;
        for (int i = 0; i < arr1.length - 1; i++) {

            int num1 = arr1[i];
            int num2 = arr2[i];

            if (num1 > last1 || num2 > last2) {
                if (num1 <= last2 && num2 <= last1) {
                    res += 1;
                } else {
                    res -= 1;
                    break;
                }
            } else if (num1 > last2 || num2 > last1) {
                cannot += 1;
            }
        }
        if (res != -1 && res > arr1.length / 2) {
            res = arr1.length - res;
        }
        if (cannot < res) {
            res = cannot;
        }
        return cannot;

    }
}
