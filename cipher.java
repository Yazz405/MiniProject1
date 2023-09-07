import java.lang.String;
import java.io.PrintWriter;

public class cipher {

  //key will be negative for decrypt
  //need to fix for negative num
  public static char charArithmetic(char character, int key){
    int base = (int) 'a';
    int result = ((character - base) + key) % 26;

    return (char) (result + base);
  }

  public static String encode(String pText, int key){

    char[] newText = pText.toCharArray();

    //for loop will encode the plain text using the key
    for(int i = 0; i < pText.length(); i++){
      newText[i] = charArithmetic(newText[i], key);

    }//for

    return new String(newText);
  }

  public static String decode(String pText, int key){

    char[] newText = pText.toCharArray();

    //for loop will decode according to the key
    for(int i = 0; i < pText.length(); i++){
      newText[i] = charArithmetic(newText[i], key);

    }//for

    return new String(newText);

  }

  public static void CesarCipher (String use, String text){
    
    if(use.equals("encode")){
      
      //The for loop will print every possible way to encode the phrase
      for(int i = 0; i < 26; i++){
        System.out.println("n = " + i + ": " + encode(text, i) + "\n");

      }//for
    }//if
    else if(use.equals("decode")){
      for(int i = 0; i < 26; i++){
        System.out.println("n = " + i + ": " + decode(text, -i) + "\n");
      }//for

    }//if
    

    char a = use.charAt(2);
    //System.out.println(charAddition(plainText[0], 1));
  }
  ///
  ///
  ///
   //Vigenère Cipher
   public static void VigenereCipher(String use, String text, String key){
      
  }
  

  public static void main(String[] args){
    CesarCipher(args[0], args[1]);

}


}