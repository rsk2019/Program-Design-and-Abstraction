/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SouthieAccent {
    /* url is the address of a file on the web, e.g., http://www.espn.com
 * If successful, the method returns the contents of the URL as a String.
 * On failure, it returns null */
    public static String getWebContents(String url) {
        BufferedReader br = null;
        String result = null;
        try {
            URL toFetch = new URL(url);
            br = new BufferedReader(new InputStreamReader(toFetch.openStream()));
            StringBuilder ret = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                ret.append(line+'\n');
                line = br.readLine();
            }
            result = ret.toString();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            System.err.println("Malformed URL:  " + url);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error reading from URL:  " + url);
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.err.println("Couldn't close connection to url properly:  " + url);
                }
            }
            return result;
        }
    }

    /* Saves the String contents into a file with name filename.
     * 
     * If the file did not previously exist, it is created.
     * If the file with the same name existed previously, it is overwritten. */
    public static void saveDoc(String contents, String filename) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File(filename)));
            pw.print(contents);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error writing to file:  " + filename);
        } finally {
            if(pw!=null) {
                pw.close();
            }
        }
    }

    public static boolean isVowel(char c){
        boolean letter = false;
        if (c >= 'a' && c <= 'z'){
            System.out.println("Lowercase.");
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                return letter = true;
            }
            else{
                return letter = false;
            }
        }

        if (c >= 'A' && c <= 'Z'){
            System.out.println("Uppercase.");
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                return letter = true;
            }
            else{
                return letter = false;
            }
        }

        return letter;
    }
        
    public static String getConvertedString(String s){
        Scanner input = new Scanner(s);
        input.useDelimiter("\\s");
        String word;
        String newSentence = "";        
        while (input.hasNext()){
            word = input.next();
            int j = 1;
            int a;
            if (word.contains(",")||word.contains("?")||word.contains("!")||word.contains(".")){
               a = 2; 
            }
            else a = 1;
            if (word.length()>=3){
                if (word.equals("very")){
                    word = "wicked";
                }
                else if (word.equals("Very")){
                    word = "Wicked";
                }
                while (j<word.length()){
                    if (word.charAt(j)=='r' && isVowel(word.charAt(j-1))){
                        if (word.charAt(word.length()-a)=='r' && word.charAt(word.length()-a-1)=='e' && word.charAt(word.length()-a-2)=='e'){
                            if (a==2)
                                word = word.substring(0, word.length()-a) + 'y' + 'a' + 'h' + word.charAt(word.length()-1);
                            else word = word.substring(0,word.length()-a) + 'y' + 'a' + 'h';
                        } else if (word.charAt(word.length()-a)=='r' && word.charAt(word.length()-a-1)=='o' && word.charAt(word.length()-a-2)=='o'){
                            if (a==2)
                                word = word.substring(0, word.length()-a) + 'w' + 'a' + 'h' + word.charAt(word.length()-1);
                            else word = word.substring(0,word.length()-a) + 'w' + 'a' + 'h';
                        }   
                        else word = word.substring(0,j) + 'h' + word.substring(j+1,word.length());
                    } else if(word.charAt(j)=='R' && isVowel(word.charAt(j-1)))
                        word = word.substring(0,j) + 'H' + word.substring(j+1,word.length()); 
                    j++;
                }
                if (word.charAt(word.length()-a)=='a'){
                    if (a==2)
                        word = word.substring(0, word.length()-1) + 'r' + word.charAt(word.length()-1);
                    else word = word + 'r';
                }
            }
            newSentence = newSentence + word + " ";
        }
        return newSentence;
    }
    
    

    public static void main(String[] args) {
       String movieSub = getWebContents("https://cis.temple.edu/~jfiore/2017/fall/1068/assignments/07/files/jaws.txt");
       Scanner fromWeb = new Scanner(movieSub);
       fromWeb.useDelimiter("\\n");
       String line;
       String newLine;
       String all = "";
       while(fromWeb.hasNext()){
           line = fromWeb.next();
           newLine = getConvertedString(line) + "\n";
           all = all + newLine;           
       }
       saveDoc(all, "SouthieAccentConvertedFile.doc");
    }
    
}
