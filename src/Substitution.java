// This class represents a Substitution Cipher, which replaces each input character with 
// a unique output character.
public class Substitution extends Cipher {
    // The String of output characters that will be swapped with the characters at the same
    // position in the encodable range
    private String encoding;

    // Creates a new Substitution with an empty encoding
    public Substitution() {
        encoding = "";
    }

    // Behavior:
    //   - Creates a new Substitution cipher and sets its encoding String
    // Exceptions:
    //   - throws an IllegalArgumentException if
    //       - the given encoding is null
    //       - the length of the encoding does not match the length of the encodable range
    //       - the encoding contains a duplicate character
    //       - any character in the encoding falls outside of the encodable range
    // Parameters:
    //   - String encoding - the String of output characters that will be swapped with the
    //     input characters
    public Substitution(String encoding) {
        setEncoding(encoding);
    }

    // Behavior:
    //   - Updates the encoding for this Substitution cipher
    // Exceptions:
    //   - throws an IllegalArgumentException if
    //       - the given encoding is null
    //       - the length of the encoding does not match the length of the encodable range
    //       - the encoding contains a duplicate character
    //       - any character in the encoding falls outside of the encodable range
    // Parameters:
    //   - String encoding - the String that this Substitution cipher's encoding variable will
    //     be updated to 
    public void setEncoding(String encoding) {
        if (encoding == null) {
            throw new IllegalArgumentException("Encoding cannot be null");
        } else if (encoding.length() != TOTAL_CHARS) {
            throw new IllegalArgumentException("Encoding must be same length as encodable range");
        }
        for (int i = 0; i < encoding.length(); i++) {
            char current = encoding.charAt(i);
            if ((int) current < MIN_CHAR || (int) current > MAX_CHAR) {
                throw new IllegalArgumentException("All characters must fall inside the " +
                    "encodable range");
            }
            for (int j = 0; j < encoding.length(); j++) {
                if (i != j) {
                    if (current == encoding.charAt(j)) {
                        throw new IllegalArgumentException("Encoding cannot have duplicate " +
                            "characters");
                    }
                }
            }
        }
        this.encoding = encoding;
    }

    // Behavior:
    //   - Applies this Substitution's encryption scheme to 'input', returning the result
    // Exceptions: 
    //   - throws an IllegalArgumentException if 'input' is null
    //   - throws an IllegalStateException if the encoding was never set
    // Returns:
    //   - the result of applying this Substitution's encryption scheme to 'input'
    // Parameters:
    //   - String input - the String to be encrypted. Should be non-null and all characters
    //     should be within the encodable range
    public String encrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        } else if (encoding.equals("")) {
            throw new IllegalStateException("Encoding was never set");
        }
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int index = (int) current - MIN_CHAR;
            output += encoding.substring(index, index + 1);
        }
        return output;

    }
    // Behavior:
    //   - Applies the inverse of this Substitution's encryption scheme to 'input' (reversing a
    //     single round of encryption if previously applied), returning the result
    // Exceptions: 
    //   - throws an IllegalArgumentException if 'input' is null
    //   - throws an IllegalStateException if the encoding was never set
    // Returns:
    //   - the result of applying the inverse of this Substitution's encryption scheme to 'input'
    // Parameters:
    //   - String input - the String to be decrypted. Should be non-null and all characters
    //     should be within the encodable range
    public String decrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        } else if (encoding.equals("")) {
            throw new IllegalStateException("Encoding was never set");
        }
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int index = encoding.indexOf(current);
            output += (char) (index + MIN_CHAR);
        }
        return output;
    }
}
