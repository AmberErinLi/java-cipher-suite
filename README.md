# Java Cipher Suite

A Java project implementing a variety of classical ciphers, including **Caesar (key and shift variants), substitution ciphers, and a MultiCipher** that combines different encoding methods. This project demonstrates object-oriented design, inheritance, and abstract classes in Java while practicing encryption and decryption algorithms.

---

## 🛠️ Features
- **Cipher Base Class:** Abstract `Cipher` class defining `encrypt` and `decrypt` methods, plus reusable methods for file encryption/decryption.
- **Substitution Cipher:** Implements basic character substitution with customizable encodings.
- **Caesar Ciphers:**  
  - **Caesar Shift:** Shifts characters by a fixed number.  
  - **Caesar Key:** Uses a key-based shift encoding.  
- **MultiCipher:** Combines multiple ciphers in sequence for more complex encryption.  

---

## 🧩 Design & Inheritance
- `Cipher` is the abstract base class providing shared instance variables (`MIN_CHAR`, `MAX_CHAR`, `TOTAL_CHARS`) and reusable file encryption methods.  
- `Substitution` extends `Cipher` to implement concrete `encrypt` and `decrypt` methods.  
- `CaesarShift` and `CaesarKey` extend `Substitution` because they reuse the same encryption logic but override or overload the `setEncoding` method.  
- `MultiCipher` extends `Cipher` separately, implementing its own `encrypt` and `decrypt` methods without inheriting substitution-specific logic.  

This hierarchy minimizes redundancy while keeping the design flexible for future cipher additions.

---

## 🎯 Skills Practiced
- Java **abstract classes and inheritance**  
- Code quality: commenting, reducing redundancy, and clear method design  
- Array indexing and element shifting for character encoding  
- Exception handling for invalid encodings and input validation  

---

## ⚡ Challenges
- Determining the optimal class hierarchy to avoid redundancy but maintain clarity.  
- Deciding whether to create helper methods (like a shared encoding checker) and balancing code reuse with simplicity.  
- Ensuring all ciphers correctly handled edge cases in character encodings.

---

## 🔗 Usage
1. Clone the repository:
```bash
git clone https://github.com/AmberErinLi/java-cipher-suite.git
```
2. Open the project in your IDE (Visual Studio Code, IntelliJ, etc.).
3. Run the main() method (in MultiCipher or a dedicated driver class) to test encryption/decryption.
4. Modify or add text files to experiment with different ciphers.

---

## 📂 Repository Structure
The project is organized as follows:

```text
java-cipher-suite/
├── src/
│   ├── CaesarKey.java      # Implements Caesar key cipher
│   ├── CaesarShift.java    # Implements Caesar shift cipher
│   ├── Cipher.java         # Abstract base class defining encrypt/decrypt methods
│   ├── Client.java         # Contains main() method to run and test ciphers
│   ├── MultiCipher.java    # Combines multiple ciphers
│   ├── Substitution.java   # Implements substitution cipher
│   └── Testing.java        # JUnit tests for all cipher classes and methods
├── README.md               # Project overview and instructions
└── .gitignore              # Ignore compiled files and IDE artifacts
```
