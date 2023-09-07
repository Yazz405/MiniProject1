import java.lang.String;
import java.io.PrintWriter;

public class CesarCipher {

  //PreConditions: key will be negative if subtraction is needed
  //PostConditions: A char will return as a result of either adding or subtractacting character and key
  //               'a' will be associated with the number 0 and each lowercase letter will follow
  public static char charArithmetic(char character, int key){
    int base = (int) 'a';
    int movement = ((character - base) + (key));
    int result;

    result = movement % 26;

    if(result < 0){
      result += 26;
    }//if

    return (char) (result + base);
  }

  //PreConditions: none
  //PostConditions: pText will be encoded( if >= 0) or decoded( if < 0) and will be returned as a string
  public static String code(String pText, int key){

    char[] newText = pText.toCharArray();

    for(int i = 0; i < pText.length(); i++){
      newText[i] = charArithmetic(newText[i], key);
    }//for

    return new String(newText);
  }

  public static void main(String[] args){

    PrintWriter pen;
    pen = new PrintWriter(System.out, true);

    //error checking
    if(args.length != 2){
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    }//if
    if((args[0] != "encode") || (args[0] != "decode")){
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    }//if



    if(args[0].equals("encode")){ 
      //The for loop will print every possible way to encode the phrase
      for(int i = 0; i < 26; i++){
        pen.println("n = " + i + ": " + code(args[1], i) + "\n");

      }//for
    }//if
    else if(args[0].equals("decode")){
      //The for loop will print every possible way to decode the phrase
      for(int i = 0; i < 26; i++){
        pen.println("n = " + i + ": " + code(args[1], -i) + "\n");
      }//for

    }//if

    pen.flush();
    
  }//main
}// class CesarCipher