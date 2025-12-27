import java.util.*;

// This class represents a MultiCipher, which passes inputs through multiple Ciphers to
// create a harder to decrypt output.
public class MultiCipher extends Cipher {
    // The list of Ciphers that the input will be passed through
    private List<Cipher> ciphers;

    // Behavior:
    //   - Creates a new MultiCipher and sets its list of Ciphers
    // Exceptions:
    //   - throws an IllegalArgumentException if the provided list is null
    // Parameters:
    //   - List<Cipher> ciphers - the ciphers that inputs will be encrypted/decrypted with
    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException("Ciphers cannot be null");
        }
        this.ciphers = ciphers;
    }

    // Behavior:
    //   - Encrypts 'input' by passing it through each Cipher of the MultiCipher one by one. The
    //     next Cipher in the list will encrypt the output from the previous Cipher.
    // Exceptions:
    //   - throws an IllegalArgumentException if 'input' is null
    // Returns:
    //   - the result of applying all of the Ciphers' encryption schemes to 'input'
    // Parameters:
    //   - String input - the String to be encrypted.  
    public String encrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        for (int i = 0; i < ciphers.size(); i++) {
            input = ciphers.get(i).encrypt(input);
        }
        return input;
    }

    // Behavior:
    //   - Decrypts 'input' by passing it through each Cipher of the MultiCipher in reverse order.
    //     The inverse of each Cipher's encryption scheme will be applied to 'input'.
    // Exceptions:
    //   - throws an IllegalArgumentException if 'input' is null
    // Returns:
    //   - the result of applying the inverse of all the Ciphers' encryption schemes in reverse
    //     order to 'input'
    // Parameters:
    //   - String input - the String to be decrypted. 
    public String decrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            input = ciphers.get(i).decrypt(input);
        }
        return input;
    }
}
