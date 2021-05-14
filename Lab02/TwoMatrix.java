import java.util.Scanner;

public class TwoMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		int mt1[][] = new int[100][100];
        int mt2[][] = new int[100][100];
        System.out.print("Enter the matrix size : ");
        int size = new Scanner(System.in).nextInt();
        System.out.println("Enter first matrix: ");
        
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mt1[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter second matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mt2[i][j] = input.nextInt();
            }
        }

        System.out.println("First Matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ",mt1[i][j]);
            }
            System.out.println();
        }
        System.out.println("Second Matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ",mt2[i][j]);
            }
            System.out.println();
        }

		input.close();
    }
}