import java.util.Scanner;

public class Array {

    public static double caclAvg (int[] arr) {
        double sum = 0 , count = 0;
        for (int i = 0; i < arr.length; i++) {    
            sum += arr[i];
            count++;
        }
        double avg = sum/count;
        return avg;
    }

    public static int calcSum (int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void Sort (int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j]; 
                    arr[j] = arr[j-1]; 
                    arr[j-1] = temp; 
                }
            }
        }
    }

    public static void inputArray (int[] arr) {
        
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }

        input.close();
    }

    public static void printArray (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements you want in array: ");
        n = s.nextInt();
        int[] arr = new int[n];
        inputArray(arr);
        System.out.println("Unsorted array: ");
        printArray(arr);
        System.out.println("\nSorted array: ");
        Sort(arr);
        printArray(arr);
        System.out.println("\nSum of array is : " +calcSum(arr));
        System.out.println("Average of array is : "+caclAvg(arr));

        s.close();
    }
}
