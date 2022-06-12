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

