package chapter6;

public class StringParamTest {
    
    // Try to change String
    public static void changeString(String str) {
        str = "Changed in method";
        System.out.println("Inside method: str = " + str);
    }
    
    // Try to modify String using methods
    public static void modifyString(String str) {
        str = str + " - Modified";
        System.out.println("Inside method after modify: str = " + str);
    }
    
    // Compare with StringBuilder (mutable)
    public static void changeStringBuilder(StringBuilder sb) {
        sb.append(" - Modified");
        System.out.println("Inside method: sb = " + sb);
    }
    
    public static void main(String[] args) {
        // String test
        String original = "Original String";
        
        System.out.println("=== String Test ===");
        System.out.println("Before: original = " + original);
        
        changeString(original);
        
        System.out.println("After: original = " + original); // Unchanged!
        
        System.out.println("\n=== String Modify Test ===");
        System.out.println("Before modify: original = " + original);
        
        modifyString(original);
        
        System.out.println("After modify: original = " + original); // Still unchanged!
        
        // StringBuilder test (mutable)
        StringBuilder sb = new StringBuilder("Original StringBuilder");
        
        System.out.println("\n=== StringBuilder Test ===");
        System.out.println("Before: sb = " + sb);
        
        changeStringBuilder(sb);
        
        System.out.println("After: sb = " + sb); // Changed!
    }
}
