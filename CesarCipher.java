import java.lang.String;
import java.io.PrintWriter;

public class CesarCipher {

  //key will be negative for decrypt
  //need to fix for negative num
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

  public static String code(String pText, int key){

    char[] newText = pText.toCharArray();

    //for loop will encode the plain text using the key
    for(int i = 0; i < pText.length(); i++){
      newText[i] = charArithmetic(newText[i], key);
    }//for

    return new String(newText);
  }

  public static void main(String[] args){

    PrintWriter pen;
    pen = new PrintWriter(System.out, true);

    if(args[0].equals("encode")){ 
      //The for loop will print every possible way to encode the phrase
      for(int i = 0; i < 26; i++){
        pen.println("n = " + i + ": " + code(args[1], i) + "\n");

      }//for
    }//if
    else if(args[0].equals("decode")){
      for(int i = 0; i < 26; i++){
        pen.println("n = " + i + ": " + code(args[1], -i) + "\n");
      }//for

    }//if

    pen.flush();
    
  }//main
}// class CesarCipher