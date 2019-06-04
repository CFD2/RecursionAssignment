import java.io.File;
import java.util.Scanner;
import java.util.Stack;

import static java.io.File.separator;

/**
 * @author Vadim Yastrebov (100908473)
 * @version 2017.07.05
 */
public class TestFindPath {
    private static Stack <String> fileStack;
    public static void main(String[] args) {
        //QUESTION 2
        fileStack = new Stack<>();  //using stack to have search results saved instead of just printing to terminal
        try {

            System.out.println("Type in your path:");
            File root = new File (new Scanner(System.in).nextLine());
//            File root  = new File("/Users/CFD2/Documents/");  for debugging. filepath hardcoded. I am using Mac.
            System.out.println("Using root: " + root.toString());



            System.out.println("Type in your filename/folder name: ");
            String filename = new Scanner(System.in).nextLine();
//            String filename = new String("ideaHotkeys1.pdf"); for debugging code in case of problems
            System.out.println("Looking for: " + filename);


            System.out.println("\nResult:");
            find(root, filename);

            while (!fileStack.empty()) {
                System.out.println(fileStack.pop());    //using this stack to print results
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //END QUESTION 2
    }

    /**
     * Take this filepath and compare it to filename.
     * @param root target directory to search
     * @param filename target filename/directory to find
     * @return to leave recursion (why is this not void?)
     * @throws Exception if incorrect root specified
     */
    public static File find(File root, String filename) throws Exception{
        if (!root.exists()) {
            throw new NullPointerException("Path doesn't exist...\n");

        } else {
            //BASE CASE
            if (filename.equals(root.getName())) {
//                System.out.println(root.toString()); //can use this for simple printing of search results
                fileStack.push(root.toString());    //Using stack to save search results in case we need to manipulate them later (access a file etc.)
            }
            if (root.isDirectory() && (root.list().length > 0)) {
                for (String currentFile : root.list()) {
                    find(new File(root.toString() + separator + currentFile), filename);

                }
            }
            return root;
        }
    }
}
