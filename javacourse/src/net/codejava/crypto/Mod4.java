//Module 04 Course Project - Functioning Java Program and Encryption Algorithms

package javacourse;

import java.io.*;
import java.util.*;
public class Mod4 {
public static void main(String[] args){
try {
Scanner in = new Scanner(System.in);
System.out.println("Enter the name of the file to read: ");
String filename = in.nextLine();
Scanner sc = new Scanner(new File(filename));
//reading the contents of the file
while(sc.hasNextLine()){
String line = sc.nextLine();
System.out.println("Line before filtering:");
System.out.println(line);
System.out.println("Line after filtering:");
for (int i = 0; i < line.length(); i++) {
char ch = line.charAt(i);
if(Character.isLetterOrDigit(ch) || ch == '.'||
ch == ','||ch == '!'||ch == '?'||ch == ' '){
//printing only letters, numbers and some punctuation
System.out.print(ch);
}
}
System.out.println("\n");
}
} catch (FileNotFoundException e) {
//if file was not found
System.out.println("File Error!");
}
}
}






package net.codejava.crypto;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.security.InvalidKeyException;

import java.security.Key;

import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;

import javax.crypto.IllegalBlockSizeException;

import javax.crypto.NoSuchPaddingException;

import javax.crypto.spec.SecretKeySpec;

/**

* A utility class that encrypts or decrypts a file.

*

*/

public class CryptoUtils {

    private static final String ALGORITHM = "AES";

    private static final String TRANSFORMATION = "AES";

    public static void encrypt(String key, File inputFile, File outputFile)

            throws CryptoException {

        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);

    }

    public static void decrypt(String key, File inputFile, File outputFile)

            throws CryptoException {

        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);

    }

    private static void doCrypto(int cipherMode, String key, File inputFile,

            File outputFile) throws CryptoException {

        try {

            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);

            cipher.init(cipherMode, secretKey);

            

            FileInputStream inputStream = new FileInputStream(inputFile);

            byte[] inputBytes = new byte[(int) inputFile.length()];

            inputStream.read(inputBytes);

            

            byte[] outputBytes = cipher.doFinal(inputBytes);

            

            FileOutputStream outputStream = new FileOutputStream(outputFile);

            outputStream.write(outputBytes);

            

            inputStream.close();

            outputStream.close();

            

        } catch (NoSuchPaddingException | NoSuchAlgorithmException

                | InvalidKeyException | BadPaddingException

                | IllegalBlockSizeException | IOException ex) {

            throw new CryptoException("Error encrypting/decrypting file", ex);

        }

    }

}