import java.io.File;

/**
 * Recursive questions
 * @author Emre Karatas - 22001641
 * @version v1.0 - 22.07.2021
 */
public class Lab06
{
    /**
     * QUESTION 1
     * @param str
     * @return
     */
    public static int lengthCounter(String str)
    {
        if (str.length() == 0)
        {
            return 0;
        }
        return 1 + lengthCounter(str.substring(1));
    }


    /**
     * QUESTION 2
     * @param str
     * @return
     */
    public static int countNonVowels(String str)
    {
        String newStr = str.toLowerCase().replaceAll("[0123456789]","").replaceAll(" ","");
        int length = lengthCounter(newStr);
        if ( length == 0)
        {
            return 0;
        }
        if (newStr.charAt(0) != 'a' && newStr.charAt(0) != 'e' && newStr.charAt(0) != 'i' && newStr.charAt(0) != 'o' && newStr.charAt(0) != 'u' )
        {
            return 1 + countNonVowels(newStr.substring(1));
        }
        return countNonVowels(newStr.substring(1));
    }


    /**
     * QUESTION 3
     * @param n
     * @param output
     * @param lastValue
     */
    public static void binaryStringCreator(int n, int lastValue, String output)
    {
        if (n == 0)
        {
            System.out.println(output);
            return;
        }
        binaryStringCreator(n - 1, 0, output + '0');
        if (lastValue != 1)
            binaryStringCreator(n - 1, 1, output + '1');
    }



    /**
     * Helper method for QUESTION 3
     * @param n
     */
    public static void binaryStrings(int n)
    {
        binaryStringCreator(n,0,"");
    }

    /**
     * QUESTION 4
     * @param file
     * @return
     */
    public static int numOfFiles(File file )
    {
        int count = 0;
        if (!file.isDirectory())
        {
            return 0;
        }
        File[] fileList = file.listFiles();
        for ( File f : fileList)
        {
            if ( f.isFile())
            {
                count++;
            }
            else if ( f.isDirectory())
            {
                count += numOfFiles(f);
            }

        }
        return count;

    }


    /**
     *Main method
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("QUESTION 1");
        System.out.println(lengthCounter("CS102 is the best"));
        System.out.println("QUESTION 2");
        System.out.println(countNonVowels("CS102 is a good course"));
        System.out.println("QUESTION 3");
        binaryStrings(3);
        System.out.println("QUESTION 4");
        System.out.println(numOfFiles(new File("C:\\Users\\user\\Desktop\\Games")));


    }
}
