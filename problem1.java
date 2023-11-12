class problem1 {
    public static int solver(int[] arr) {

        int maxXor = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int x = arr[i];
                int y = arr[j];
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    maxXor = Math.max(maxXor, x ^ y);
                }
            }
        }
        return maxXor;
    }
}