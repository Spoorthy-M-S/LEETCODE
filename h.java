public class h {
    public static boolean judgeSquareSum(int c) {
        int arr[] = new int[c + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int x = arr[i] * arr[i] + (arr[j] * arr[j]);
                //int y = (arr[i] * arr[i]) + arr[i] * arr[i];
               // int z = (arr[j] * arr[j]) + ((arr[j] * arr[j]));
                System.out.println(x);
              //  System.out.println(y);
               // System.out.println(z);
                if (x == c) {
                    return true;
                }
                // if (y == c) {
                //     return true;
                // }
                // if (z == c) {
                //     return true;
                // }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 4;
        System.out.println(judgeSquareSum(c));
    }

}
