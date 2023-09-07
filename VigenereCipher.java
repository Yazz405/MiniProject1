import java.lang.String;
import java.io.PrintWriter;

public class VigenereCipher {

  //Preconditions: the inputed chars are lowercase letters a-z
  //PostConditions: the result of adding the two chars together will be returned as a char
  //                'a' will be associated with the number 0 and each lowercase letter will follow
  public static char charAdd(char text, char key){
    int base = (int) 'a';
    int result  = ((text - base) + (key - base)) % 26;

    return (char) (result + base);
  }//charAdd

  //PreConditions: the unputed chars are lowecase letters a-z
  //PostConditions: the result of subtracting the two chars together will be returned as a char
  //                'a' will be associated with the number 0 and each lowercase letter will follow
  public static char charSubtract(char text, char key){
    int base = (int) 'a';
    int result = ((text - base) - (key - base)) % 26;

    if(result < 0){
      result = result + 26;
    }//if
    
    return (char) (result + base);
  }//charSubtract

  //PreConditions: none
  //PostConditions: text will be decoded or encoded using key and returned as a string
  public static String code(String use, String text, String key){
    
    //variable declarations
    char[] newText = text.toCharArray();
    char[] newKey = key.toCharArray(); 
    char[] result = new char[text.length()];
    int j = 0;

    for(int i = 0; i < text.length(); i++){
      //for loop will allow the key to keep repeating until the end of text
      if(j > (key.length() - 1)){
        j = 0;
      }//if

      if(use.equals("encode")){
        result[i] = charAdd(newText[i], newKey[j]);
      }//if
      else{
        result[i] = charSubtract(newText[i], newKey[j]);
      }//else

      j++;
    }//for

    return new String(result);
  }//code

  public static void main(String[] args) {
    PrintWriter pen;
    pen = new PrintWriter(System.out, true);

    //error checking
    if(args.length != 3){
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    }//if
    if((args[0] != "encode") || (args[0] != "decode")){
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    }//if

    pen.println(code(args[0], args[1], args[2]));

  }// main
}// class VigenereCipher
