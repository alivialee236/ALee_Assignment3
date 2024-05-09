/*
 * Class: CMSC203 CRN 30339
 * Instructor: Professor Grinberg
 * Description: This is a utility class that encrypts
 * and decrypts a phrase using two different approaches.
 * The first approach is called the Caesar Cipher and is
 * a simple substitution cipher where characters in a 
 * message are replaced by a substitute character. 
 * The second approach, due to Giovan Battista Bellaso, 
 * uses a key word, where each character in the word specifies
 * the offset for the corresponding character in the message,
 * with the key word wrapping around as needed.
 * Due: 03/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alivia Lee
*/

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		for (int count = 0; count < plainText.length(); count++) {
			
			char letter = plainText.charAt(count);
			if (letter < LOWER_RANGE || letter > UPPER_RANGE) {//tests whether out of range
				
				System.out.println("The selected string is not in bounds, Try again.");
				return false;
			}
			
		}
		
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		StringBuilder encrypted = new StringBuilder();
		if (isStringInBounds(plainText)) {
			for (int i = 0; i < plainText.length(); i++) {//replaces each char and makes sure it is within range
				int replace = plainText.charAt(i) + key;
				while(replace > UPPER_RANGE) {
					replace -=(RANGE);
				}
				encrypted.append((char)replace);
			}
			return encrypted.toString();
		}else {
			return ("The selected string is not in bounds, Try again.");
		}
	}
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		StringBuilder encrypted = new StringBuilder();
		StringBuilder extend = new StringBuilder();
		while(extend.length() < plainText.length()) {//extends the key
			extend.append(bellasoStr);
		}
			
		String key = extend.toString();
		for(int i = 0; i < plainText.length(); i++) {//replaces with the offset
			char ch = plainText.charAt(i);
			char offset = key.charAt(i);;
			int replace = (ch + offset);
			while(replace >= UPPER_RANGE) {
				replace -= RANGE;
			}
			encrypted.append((char)replace);
		}
		return encrypted.toString();
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		StringBuilder decrypted = new StringBuilder();
		for (int i = 0; i < encryptedText.length(); i++) {
			int replace = encryptedText.charAt(i) - key;
			while (replace < LOWER_RANGE) {
				replace += RANGE;
			}
			decrypted.append((char)replace);
		}
		return decrypted.toString();
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		StringBuilder decrypted = new StringBuilder();
		StringBuilder extend = new StringBuilder();
		
		while (extend.length() < encryptedText.length()){
			extend.append(bellasoStr);
		}
		String key = extend.toString();
		bellasoStr = key;
		for(int i = 0; i < encryptedText.length(); i++) {
			char ch = encryptedText.charAt(i);
			char offset = key.charAt(i);
			int replace = (ch - offset) % RANGE;
			while (replace < LOWER_RANGE) {
				replace += RANGE;
			}
			decrypted.append((char)replace);
		}
		return decrypted.toString();
	}
	
	
	
}
