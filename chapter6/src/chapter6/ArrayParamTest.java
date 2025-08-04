package chapter6;

public class ArrayParamTest {
    
    // Change array element
    public static void changeArray(int[] arr) {
        arr[0] = 999;
        System.out.println("Inside method: arr[0] = " + arr[0]);
    }
    
    // Reassign array reference
    public static void reassignArray(int[] arr) {
        arr = new int[]{100, 200, 300};
        System.out.println("Inside method after reassign: arr[0] = " + arr[0]);
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("=== Array Element Change Test ===");
        System.out.println("Before: numbers[0] = " + numbers[0]);
        
        changeArray(numbers);
        
        System.out.println("After: numbers[0] = " + numbers[0]); // Original changed!
        
        System.out.println("\n=== Array Reassign Test ===");
        System.out.println("Before reassign: numbers[0] = " + numbers[0]);
        
        reassignArray(numbers);
        
        System.out.println("After reassign: numbers[0] = " + numbers[0]); // Original unchanged
    }
}
