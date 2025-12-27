// This class represents a CaesarKey Cipher, which replaces each input character with the
// character in encoding at the same relative position. This encoding is created by placing
// a key at the front, with the rest of the alphabet following normally.
public class CaesarKey extends Substitution {

    // Behavior:
    //   - Creates a new CaesarKey cipher and sets its encoding String
    // Parameters:
    //   - String key - the key that will be used to create the encoding String
    public CaesarKey(String key) {
        setEncoding(key);
    }

    // Behavior:
    //   - Sets the encoding String for this CaesarKey cipher using the given key. The encoding
    //     String becomes the key with the rest of the encodable range in alphabetical order
    //     added onto the end.
    // Exceptions:
    //   - throws IllegalArgumentException if
    //       - the given key is null
    //       - the given key is empty
    //       - the key contains a duplicate character
    //       - any character in the key falls outside of the encodable range
    // Parameters:
    //   - String key - the key that will be at the beginning of this CaesarKey's encoding
    public void setEncoding(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (key.equals("")) {
            throw new IllegalArgumentException("Key cannot be empty");
        }
        for (int i = 0; i < key.length(); i++) {
            char current = key.charAt(i);
            if ((int) current < MIN_CHAR || (int) current > MAX_CHAR) {
                throw new IllegalArgumentException("All characters must fall inside the " +
                    "encodable range");
            }
            for (int j = 0; j < key.length(); j++) {
                if (i != j) {
                    if (current == key.charAt(j)) {
                        throw new IllegalArgumentException("Key cannot have duplicate " +
                            "characters");
                    }
                }
            }
        }
        String encoding = key;
        for (int i = MIN_CHAR; i <= MAX_CHAR; i++) {
            if (!encoding.contains(Character.toString((char) i))) {
                encoding += (char) i;
            }
        }
        super.setEncoding(encoding);
    }
}
