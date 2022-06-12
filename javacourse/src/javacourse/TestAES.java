package javacourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestAES {
   final String secretKey = "abcdefgh!!!!";
   String encryptedString;
   String decryptedString;
   String originalString;
   String filedata="";
   String fileEncryptData;
   String fileDecryptedData;
  
   public static void main(String[] args)
   {
   TestAES t=new TestAES();
     
   Scanner sc= new Scanner(System.in);
       System.out.println("Enter text");
       t.originalString=sc.next();
       t.encryptedString=t.encryptKeyBoardInput();
       t.decryptedString=t.decryptInput();
         
   System.out.println(t.originalString);
   System.out.println(t.encryptedString);
   System.out.println(t.decryptedString);
   //file data
   t.fileEncryptData=t.encryptFromFile();
   t.fileDecryptedData=t.decryptFileData();
   System.out.println(t.fileEncryptData);
   System.out.println(t.fileDecryptedData);
   }
  
   String encryptKeyBoardInput(){
      
       return AES.encrypt(originalString, secretKey);
   }
   String decryptInput(){
       return AES.decrypt(encryptedString, secretKey);
   }
  
   String encryptFromFile(){
       File file = new File("C:\\Users\\Lo\\Desktop\\Software Security\\input.txt");       
         
       try{
      
           BufferedReader br = new BufferedReader(new FileReader(file));           
           String st="";
           ArrayList<String> a=new ArrayList<String>();
          
             
           while ((st = br.readLine()) != null) {
           a.add(st);
           }
           int i=0;
           while(i<a.size())
               {
               filedata=filedata.concat(a.get(i));                 
               i++;
               }
           System.out.println("file data "+filedata);
              
          
       } catch (FileNotFoundException e) {
          
           e.printStackTrace();
       } catch (IOException e) {
          
           e.printStackTrace();
       }       
      
      
       return AES.encrypt(filedata, secretKey);
}
  
   public String decryptFileData(){
       return AES.decrypt(fileEncryptData, secretKey);
   }
  
  
}