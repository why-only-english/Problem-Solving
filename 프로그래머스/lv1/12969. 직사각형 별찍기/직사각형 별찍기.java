import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int row = 1;
        while (row <= b) {
            int column = 1;
            while (column <= a) {
                System.out.printf("*");
                column++;
            }
            System.out.println();
            row++;
        }
    }
}