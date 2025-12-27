import java.util.*;

// This class represents a CaesarShift cipher, which replaces each input character with the 
// corresponding character in encoding at the same relative position. This encoding is created by
// shifting all characters within the range to the left a specified number of times.
public class CaesarShift extends Substitution {

    // Behavior: 
    //   - Creates a new CaesarShift cipher and sets its encoding String
    // Exceptions:
    //   - throws an IllegalArgumentException if 'shift' is not positive
    // Parameters:
    //   - int shift - the number of times each character in the encodable range will be shifted
    //     to the left to create the encoding String
    public CaesarShift(int shift) {
        super();
        if (shift <= 0) {
            throw new IllegalArgumentException("Shift must be positive");
        }
        setEncoding(shift);
    }

    // Behavior:
    //   - Sets the encoding String for this CaesarShift. The encoding String will be the
    //     encodable range with each character shifted to the left 'shift' times, moving
    //     the value at the front to the end each time.
    // Parameters:
    //   - int shift - the number of times to shift each character to generate the encoding String
    public void setEncoding(int shift) {
        String encoding = "";
        Queue<Character> chars = new LinkedList<>();
        for (int i = MIN_CHAR; i <= MAX_CHAR; i++) {
            chars.add((char) i);
        }
        for (int i = 0; i < shift; i++) {
            chars.add(chars.remove());
        }
        while(!chars.isEmpty()) {
            encoding += chars.remove();
        }
        super.setEncoding(encoding);
    }
}
