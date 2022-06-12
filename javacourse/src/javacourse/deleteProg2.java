package javacourse;

import java.io.File;

public class deleteProg2 {

	public static void main(String[] args) {
		File someFile = new File("someFileName.txt");
        //delete() will return true if it deletes the file successfully
        boolean flag = someFile.delete();
        if (flag)
                System.out.println("File deleted successfully");
        else
                System.out.println("Failed to delete file");

	}
}
