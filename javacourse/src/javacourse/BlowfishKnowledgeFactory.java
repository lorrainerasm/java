package javacourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * This program demonstrates how to encrypt/decrypt input using the Blowfish
 * Cipher with the Java Cryptograhpy.
 *
 */
public class BlowfishKnowledgeFactory {

	private static Scanner sc;
	String fileData = "";

	public String encrypt(String password, String key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		byte[] KeyData = key.getBytes();
		SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, KS);
		String encryptedtext = Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
		return encryptedtext;

	}

	public String decrypt(String encryptedtext, String key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] KeyData = key.getBytes();
		SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
		byte[] ecryptedtexttobytes = Base64.getDecoder().decode(encryptedtext);
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE, KS);
		byte[] decrypted = cipher.doFinal(ecryptedtexttobytes);
		String decryptedString = new String(decrypted, Charset.forName("UTF-8"));
		return decryptedString;

	}

	public static void main(String[] args) throws Exception {

		final String key = "knowledgefactory";
		BlowfishKnowledgeFactory obj = new BlowfishKnowledgeFactory();

		sc = new Scanner(System.in);
		System.out.println("Enter text");
		final String inputdata = sc.next();

		System.out.println("input text: " + inputdata);
		String enc_output = obj.encrypt(inputdata, key);
		System.out.println("Encrypted text: " + enc_output);
		String dec_output = obj.decrypt(enc_output, key);
		System.out.println("Decrypted text: " + dec_output);

		obj.fileData = obj.getFileData();

		String fileEncryptedData = obj.encrypt(obj.fileData, key);
		System.out.println("file EncryptedData " + fileEncryptedData);
		String fileDecryptData = obj.decrypt(fileEncryptedData, key);
		System.out.println("file DecryptData " + fileDecryptData);

	}

	public String getFileData() {

		File file = new File("C:\\Users\\Lo\\Desktop\\Software Security\\input.txt");

		try {

			BufferedReader br = new BufferedReader(new FileReader(file));
			String st = "";
			ArrayList<String> a = new ArrayList<String>();

			while ((st = br.readLine()) != null) {
				a.add(st);
			}
			int i = 0;

			while (i < a.size()) {
				fileData = fileData.concat(a.get(i));
				i++;
			}
			System.out.println("file data " + fileData);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return fileData;
	}
}