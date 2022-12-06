package java;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import java.util.Scanner;
class DES {
	byte[] skey = new byte[1000];
	String skeyString;
	static byte[] raw;
	String inputMessage, encryptedData, decryptedMessage;
	Scanner sca;
	public static DES des = new DES();
	public DES() {
		try {
			sca = new Scanner(System.in);
			generateSymmetricKey();
//			System.out.println("Enter message to encrypt");
//			inputMessage=sca.nextLine(); //enter the message for encryption
//			byte[] ibyte = inputMessage.getBytes(); //extract bytes from the input message // byte[] ebyte-encrypt(raw, ibyte); //function call to encrypt
//			String encryptedData = new String(ebyte);
//			System.out.println("Encrypted message "+encryptedData);
//			byte[] dbyte= decrypt(raw,ebyte); //function call to decrypt
//			String decryptedMessage = new String(dbyte);
//			System.out.println("Decrypted message "+decryptedMessage); //display the decrypted message
		}catch (Exception e) { //exception catching
			e.printStackTrace();
		}
	}
			void generateSymmetricKey() { //function to generate a symmetric key
				try {

					Random r = new Random(); //generates a random number
					int num=r.nextInt(10000); //generates the next random number String knum = String.valueOf(num); //extracts the value of the string byte[] knumb = knum.getBytes(); //extract the bytes skey=getRawKey(knumb);
					skeyString = new String(skey);
					System.out.println("DES Symmetric key="+skeyString);
				}catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		public static byte[] getRawKey(byte[] seed) throws Exception 
		{
			KeyGenerator kgen KeyGenerator.getInstance("DES"); //secret (symmetric) key generator constructed using one of the getInstance class methods of this class
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");//Returns SecureRandom object that implements the specified Random Number Generator (RNG) algorithm.
			sr.setSeed(seed); //Reseeds the random object
			kgen.init(56, sr); //initializes the keygenerator
			SecretKey skey = kgen.generateKey(); 
			skey.getEncoded();
			return raw;
		}
		
		public static byte[] encrypt(byte[] raw, byte[] clear) throws Exception 
		{
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");//is useful for raw secret keys that can be represented as a byte array and have no key parameters associated with them Cipher cipher Cipher.getInstance("DES");// passes the name of the requested transformation to it
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec); //resets this cipher object to the state it was in when previously initialized via a call to init
			byte[] encrypted = cipher.doFinal(clear);
			return encrypted;
		}
		
		public static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception 
		{ //function to decrypt the cipher
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES"); //is useful for raw secret keys that can be represented as a byte array and have no key parameters associated with them Cipher cipher = Cipher.getInstance("DES");// passes the name of the requested transformation to it
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);//resets this cipher object to the state it was in when previously initialized via a call to init
			byte[] encryptedString = null;
			try{
				encryptedString = des.encrypt(raw);
				System.out.println("Encrypted String: " + new String(encryptedString));
			} catch(Exception e){
				e.printStackTrace();
			} finally {
			}
			return encryptedString;
		}
		public byte[] decrypt(byte[] b)throws RemoteException 
		{
			byte[] decryptedString = null;
			try{
				decryptedString=des.decrypt(raw, b);
				System.out.println("Decrypted String: "+new String(decryptedString));
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				return decryptedString;
			}
		}
}