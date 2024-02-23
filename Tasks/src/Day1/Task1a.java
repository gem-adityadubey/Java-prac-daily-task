package Day1;

import java.util.Scanner;

public class Task1a {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Size of Array: ");
    int n = sc.nextInt();
    System.out.println("Enter the array Elements: ");
    int[] arr = new int[n];
    for(int i =0;i<arr.length;i++){
        arr[i] = sc.nextInt();
    }
    System.out.println("Enter the rotation count: ");
    int rc = sc.nextInt();
    LeftRotation(arr, rc);
    for(int i : arr){
        System.out.print(i+" ");
    }
}

    private static void LeftRotation(int[] arr, int rotationCount) {
        int length = arr.length;
        int rc = rotationCount % length;
        reverseArray(arr,0,rc-1);
        reverseArray(arr,rc,length -1);
        reverseArray(arr,0,length-1);
    }

    private static void reverseArray(int[] arr, int s, int e) {
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
