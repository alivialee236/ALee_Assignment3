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
import static org.junit.Assert.*;
import org.junit.Test;
public class CryptoManagerTestStudent {

	/**
	 * tests whether the string correctly
	 * identifies if a string is in bounds
	 */
	@Test
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("IN BOUNDS"));
		assertFalse(CryptoManager.isStringInBounds("out of bounds"));
	}
	
	/**
	 * tests whether the caesar encryption is correct
	 */
	@Test
	public void testCaesarEncryption() {
		String encrypted1 = "HOW MUCH WOOD CAN A WOODCHUCK CHUCK IF A WOOD CHUCK COULD CHUCK";
		String decrypted1 = "W^&/\\$RW/&^^S/RP]/P/&^^SRW$RZ/RW$RZ/XU/P/&^^S/RW$RZ/R^$[S/RW$RZ";
		String encrypted2 = "ABC";
		String decrypted2 = "DEF";
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("java", 3));
		assertEquals(decrypted1, CryptoManager.caesarEncryption(encrypted1, 15));
		assertEquals(decrypted2, CryptoManager.caesarEncryption(encrypted2, 3));
	}
	/**
	 * tests whether the bellaso encryption is correct
	 */
	@Test
	public void testBellasoEncryption() {
		String encrypted1 = "HOW MUCH WOOD CAN A WOODCHUCK CHUCK IF A WOOD CHUCK COULD CHUCK";
		String decrypted1 = "PT#,\\]HT,&WTP,RIS,M/T[PRPZOW/KM!OZ(NR,P(\\[[S(HT!RS%O[$TI,OW]HW";
		String encrypted2 = "ABCDEFG";
		String decrypted2 = "DOVGHSZ";
		assertEquals(decrypted1, CryptoManager.bellasoEncryption(encrypted1, "HELLO"));
		assertEquals(decrypted2, CryptoManager.bellasoEncryption(encrypted2, "CMSC"));
	}
	/**
	 * tests whether the caesar decryption is correct
	 */
	@Test
	public void testCaesarDecryption() {
		String encrypted1 = "HOW MUCH WOOD CAN A WOODCHUCK CHUCK IF A WOOD CHUCK COULD CHUCK";
		String decrypted1 = "W^&/\\$RW/&^^S/RP]/P/&^^SRW$RZ/RW$RZ/XU/P/&^^S/RW$RZ/R^$[S/RW$RZ";
		String encrypted2 = "ABC";
		String decrypted2 = "DEF";
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("java", 3));
		assertEquals(encrypted1, CryptoManager.caesarDecryption(decrypted1, 15));
		assertEquals(encrypted2, CryptoManager.caesarDecryption(decrypted2, 3));
	}
	/**
	 * tests whether the bellaso decryption is correct
	 */
	@Test
	public void testBellasoDecryption() {
		String encrypted1 = "HOW MUCH WOOD CAN A WOODCHUCK CHUCK IF A WOOD CHUCK COULD CHUCK";
		String decrypted1 = "PT#,\\]HT,&WTP,RIS,M/T[PRPZOW/KM!OZ(NR,P(\\[[S(HT!RS%O[$TI,OW]HW";
		String encrypted2 = "ABCDEFG";
		String decrypted2 = "DOVGHSZ";
		assertEquals(encrypted1, CryptoManager.bellasoDecryption(decrypted1, "HELLO"));
		assertEquals(encrypted2, CryptoManager.bellasoDecryption(decrypted2, "CMSC"));
	}
	
}
