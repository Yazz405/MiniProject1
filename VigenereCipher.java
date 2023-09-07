import java.lang.String;
import java.io.PrintWriter;

public class VigenereCipher {

  public static char charAdd(char text, char key){
    int base = (int) 'a';
    int result = ((text - base) + (key - base)) % 26;

    return (char) (result + base);
  }//charAdd
//problem here
  public static char charSubtract(char text, char key){
    int base = (int) 'a';
    int result = ((text - base) - (key - base)) % 26;

    if(result < 0){
      result =+ 26;
    }//if
    
    return (char) (result + base);
  }//charSubtract

  //takes in two strings of equal lengths
  public static String code(String use, String text, String key){

    char[] newText = text.toCharArray();
    char[] newKey = key.toCharArray(); 
    char[] result = new char[text.length()];
    /*used: https://www.upgrad.com/blog/char-array-in-java/ */

    int j = 0;
    for(int i = 0; i < text.length(); i++){
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

    pen.println(code(args[0], args[1], args[2]));

    // char[] newText = args[1].toCharArray();
    // char[] newKey = args[2].toCharArray();

  }// main
}// class VigenereCipher
