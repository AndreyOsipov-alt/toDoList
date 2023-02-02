import com.toDoList.core.Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

   // private static final Pattern COMMAND_PATTERN = Pattern.compile("\\s*(?<name>[a-zA-z]+)\\s*(?<tel>[\\W+\\d+]*)\\s(?<email>\\w*\\W*\\d*\\D*)");

    public static void main(String[] args) throws IOException {
        /*String commandLine = "JHOSH +7(910)7736016 jhosh33.obana@Gmail.com ";

        Matcher matcher = COMMAND_PATTERN.matcher(commandLine);
        if (matcher.find()) {
            System.out.println("Name:" + matcher.group("name") + "\n" +
                    "Tel: " + matcher.group("tel") + "\n" +
                    "Email: " + matcher.group("email"));
        }*/
        /*String text ="print";
        int idx =text.indexOf("\s");

        System.out.println(text.substring(0,idx)+"\n"+idx);*/


        Pattern pattern = Pattern.compile("(\\S+)\\s");
        Matcher matcher = pattern.matcher("sdfs 32 sdfsfs");


        if(matcher.find()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group());
        }
        /*System.out.println(matcher.group(2));*/

       /*try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();


       }catch (IOException ex){
           ex.printStackTrace();
       }
*/

    }


}
