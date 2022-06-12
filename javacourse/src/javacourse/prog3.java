package javacourse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class prog3 {

	public static void main(String[] args) throws FileNotFoundException {
        try {
        	System.out.println("Testing");
            FileInputStream fis = 
            		new FileInputStream(System.getenv("APPDATA") + args[0]);
        } catch (FileNotFoundException e) {
                System.out.println(args[0] + " file does not exists");
                throw new FileNotFoundException();
        }
}

}
