package chapter6;

public class CharArrayTest {
    
    // Change char array elements
    public static void changeCharArray(char[] arr) {
        arr[0] = 'X';
        arr[1] = 'Y';
        System.out.println("Inside method: " + new String(arr));
    }
    
    // Compare with String (immutable)
    public static void changeString(String str) {
        str = "Changed";
        System.out.println("Inside method: " + str);
    }
    
    public static void main(String[] args) {
        // char array test
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        
        System.out.println("=== Char Array Test ===");
        System.out.println("Before: " + new String(charArray));
        
        changeCharArray(charArray);
        
        System.out.println("After: " + new String(charArray)); // Original changed!
        
        // String test for comparison
        String str = "Hello";
        
        System.out.println("\n=== String Test (for comparison) ===");
        System.out.println("Before: " + str);
        
        changeString(str);
        
        System.out.println("After: " + str); // Original unchanged!
        
        // Show that String is backed by char array internally
        System.out.println("\n=== String to char array conversion ===");
        String original = "Hello";
        char[] converted = original.toCharArray();
        
        System.out.println("Original String: " + original);
        System.out.println("Converted char array: " + new String(converted));
        
        // Modify the char array
        converted[0] = 'M';
        
        System.out.println("After modifying char array: " + new String(converted));
        System.out.println("Original String still: " + original); // String unchanged
    }
}
