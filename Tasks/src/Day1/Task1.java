package Day1;

import java.util.Scanner;

// Task 1 : Write a Java program to perform left rotation of array elements by two positions.

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array: ");
        int n = sc.nextInt();
        System.out.println("Enter the array Elements: ");
        int[] arr = new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        rotateArray(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static int[] rotateArray(int[] arr) {
        if(arr.length < 2){
            return arr;
        }
        int ele1 = arr[0];
        int ele2 = arr[1];
        for(int i = 0;i<arr.length-2;i++){
            arr[i] = arr[i+2];
        }
        arr[arr.length - 2] = ele1;
        arr[arr.length - 1] = ele2;
        return arr;
    }
}
