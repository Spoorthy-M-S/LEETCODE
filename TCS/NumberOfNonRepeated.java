//Q=Print Total Number of Non Repeated digits in the number Range
package LEETCODE.TCS;
class NumberOfNonRepeated{
public static boolean hasRepeated(int num) {
    boolean digSeen[] = new boolean[10];
    while (num > 0) {
        int dig = num % 10;
        if (digSeen[dig] == true) {
            return true;
        }
        digSeen[dig] = true;
        num = num / 10;
    }
    return false;
}
public static int cnt(int n1, int n2) {
    int cnt = 0;
    for (int i = n1; i <= n2; i++) {
        if (!hasRepeated(i)) {
            cnt++;
        }
    }
    return cnt;
}
public static void main(String[] args) {
    System.out.println(cnt(101, 200));
}}