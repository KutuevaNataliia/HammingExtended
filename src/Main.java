import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int k = input.length();
        int m = 2;
        while (Math.pow(2, m) <= m + k) {
            m++;
        }
        int n = m + k;
        int[] binary = new int[n];
        int kCounter = 0;
        int mCounter = 2;
        int[] checkPositions = new int[m];
        checkPositions[0] = 0;
        checkPositions[1] = 1;
        for (int i = 2; i < n; i++) {
            if (kCounter == k) {
                break;
            }
            if ((i & (i + 1)) != 0) {
                binary[i] = input.charAt(kCounter) == '1' ? 1 : 0;
                kCounter++;
            } else {
                checkPositions[mCounter] = i;
                mCounter++;
            }
        }
        for (int i = 0; i < m; i++) {
            int checkGap = checkPositions[i] + 1;
            int check = 2;
            int j = checkPositions[i];
            while (j < n) {
                for (int d = 0; d < checkGap; d++) {
                    if (j == n) {
                        break;
                    }
                    if (((j + 1) & j) != 0) {
                        if (check > 1) {
                            check = binary[j];
                        } else {
                            check = check ^ binary[j];
                        }
                    }
                    j++;
                }
                j += checkGap;
            }
            binary[checkPositions[i]] = check;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(binary[i]);
        }
    }
}
