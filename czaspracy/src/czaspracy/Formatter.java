package czaspracy;

/*
 * String formatting for console output
 */
public class Formatter {

    
    // Right pad a string with the specified character
    public static String padRight(String s, int size,char pad) {
        StringBuilder builder = new StringBuilder(s);
        while(builder.length()<size) {
            builder.append(pad);
        }
        return builder.toString();
    }
    
    // Left pad a string with the specified character
    public static String padLeft(String s, int size,char pad) {
        StringBuilder builder = new StringBuilder(s);
        builder = builder.reverse(); // reverse initial string
        while(builder.length()<size) {
            builder.append(pad); // append at end
        }
        return builder.reverse().toString(); // reverse again!
    }
}