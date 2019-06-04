import java.io.File;
import java.util.Scanner;

import static java.io.File.separator;

/**
  * @author Vadim Yastrebov
 * @version 2017.07.05
 */
public class TestDiskUsage {

    public static void main(String[] args) {
        // QUESTION 1

        try {
            System.out.println("Your path to directory: ");
            //Dynamically creating an object to scan for user input. If the input is not a valid path, there's an exception for that in diskUsage()
            System.out.println("Size of directory: " + diskUsage(new File(new Scanner(System.in).nextLine())) + " Bytes");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //END QUESTION 1
    }
    /**
     *
     * @param root is the specified file path of a directory/file
     * @return the size of file in bytes
     * @throws Exception if specified file path does not exist
     */
    public static long diskUsage(File root) throws Exception {
        if (!root.exists()) {
            throw new NullPointerException("Path doesn't exist...\n");

        }
        //BASE CASE
        if (root.isFile()) {
            return root.length();
        } else {
            long size = 0;
            /*
            Traverse through elements in the current directory, get their size. Go deeper if possible.
             */
            for (int i = 0; i < root.list().length; i++) {
                size += diskUsage(new File(root.toString() + separator + root.list()[i]));
            }

            return size;
        }

    }
}

