/*
 * Thang Le
 *
 * 10/19/2017
 *
 * CIS 1068 Assignment 6: Practice with static methods and strings
 *
 * This program will perform different String methods in Java
 *
 */

import java.util.Scanner;

public class StringMethods {
	
	private static final String vowels = "aeiou";

	//Check vowel character method
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

    //Show the position of the first vowel, return -1 if not found
    public static int indexOfFirstVowel (String s){

        String lowerCase = s.toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++){
            for (int j = 0; j < vowels.length(); j++){
                if (lowerCase.charAt(i) == vowels.charAt(j)){
                    return i;
                }
            }
        }
        return -1;
    }

    //Show the position of the first vowel with starting point, return -1 if not found
    public static int indexOfFirstVowel(String s, int startPosition){
        String lowerCase = s.toLowerCase();
        for (int i = startPosition; i < lowerCase.length(); i++){
            for (int j = 0; j < vowels.length(); j++){
                if (lowerCase.charAt(i) == vowels.charAt(j)){
                    return i;
                }
            }
        }
        return -1;
    }

    //Show the index of the last vowel
    public static int indexOfLastVowel(String s){
        String lowerCase = s.toLowerCase();

        for (int i = lowerCase.length()-1; i > 0; i--){
            for (int j = 0; j < vowels.length(); j++){
                if(lowerCase.charAt(i) == vowels.charAt(j)){
                    return i;
                }
            }
        }
    return -1;
    }

    //Compare the first, last, and middle character of the string
    public static boolean sameFirstLastMiddle(String s){
        String lowerCase = s.toLowerCase();
        char first = lowerCase.charAt(0), last = lowerCase.charAt(lowerCase.length()-1), middle = lowerCase.charAt(lowerCase.length() / 2);
        return first == last && first == middle && middle == last;
    }

    // Reverse the word input
    public static String reversed(String s){

    	StringBuilder input = new StringBuilder();
        input.append(s);
    	input = input.reverse();
        return input.toString();
    }

    // Show the number of occurence of the particular phrase within the word
    public static int numOccurrences(String h, String n){
        int count = 0;
        int i = 0;
        while((i = h.indexOf(n, i)) != -1){
            i += n.length();
            count++;
        }
        return count;
    }

    //Check if the word is same in reverse
    public static boolean sameInReverse(String s){
        String reverse = reversed(s);

        return reverse.equals(s);
    }

    //Replace vowel character with space
    public static String devoweled(String s) {
        return s.replaceAll("[aeiouAEIOU]", "");
    }

    //Returns a new string consisting of all of the characters of s1 and s2 interleaved with each other.
    public static String zipped(String s1, String s2){
        if (s1.length() == 0) return s2;
        if (s2.length() == 0) return s1;
        return s1.substring(0,1) + zipped (s2, s1.substring(1));
    }

    //Convert the tab character to desired number of space
    public static String tabToSpace(String s, int n) {
        String spaces = String.format("%"+ n +"s", ""); //using string format to separate space between String
        return s.replaceAll("\t", spaces);
    }

    //Check if
    public static boolean containsAll(String s, String chars) {
        return s.equalsIgnoreCase(chars);
    }

    public static int indexOfAny(String s, String chars){
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < chars.length(); j++){
                if(s.charAt(i) == chars.charAt(j)){
                    return i;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Input letter to check for vowels: ");
        char vowelsCheck = keyboard.next().charAt(0);
        System.out.println("Is it a vowel? " + isVowel(vowelsCheck));

        System.out.println();

        System.out.print("Input word to find the first vowel location: ");
        String vowels_first_position = keyboard.next();
        System.out.println("The location of the first vowels in the word " + vowels_first_position + " is " + indexOfFirstVowel(vowels_first_position));

        System.out.println();

        System.out.print("Input the word to find the position of the first vowel: ");
        String vowelsPosition = keyboard.next();
        System.out.print("Input the starting position of the word: ");
        int startingPosition = keyboard.nextInt();
        System.out.println("Starting from " + startingPosition + " position, " + "the first vowel can be found at " + indexOfFirstVowel(vowelsPosition, startingPosition));

        System.out.println();

        System.out.print("Input word to return the index of the last vowel: ");
        String lastVowel = keyboard.next();
        System.out.println("Postion of the last vowel in of" + lastVowel + " is " + indexOfLastVowel(lastVowel));

        System.out.println();

        System.out.print("Input to check for the first last and middle letter: ");
        String checkFirstLastMiddle = keyboard.next();
        System.out.println("Check for the word " + checkFirstLastMiddle + " " + sameFirstLastMiddle(checkFirstLastMiddle));

        System.out.println();

        System.out.print("Input word to return its reversed version: ");
        String reverseWord = keyboard.next();
        System.out.println("Reversed for " + reverseWord + " is " + reversed(reverseWord));

        System.out.println();

        System.out.print("Input SubString: ");
        String subStringOccurence = keyboard.next();
        System.out.print("Input word to find the occurence of the SubString: ");
        String occurence = keyboard.next();
        System.out.println("Number of occurence of " + occurence + ": " + numOccurrences(occurence, subStringOccurence));

        System.out.println();

        System.out.print("Input word here to check for its reversed version: ");
        String checkReverse = keyboard.next();
        System.out.println("Is " + checkReverse + " same in reverse? " + sameInReverse(checkReverse));

        System.out.println();

        System.out.println("Devowel the word " + " Apple "+ ": " + devoweled("Apple."));

        System.out.println();

        System.out.print("Input the 1st word being zipped: ");
        String firstZipped = keyboard.next();
        System.out.println();
        System.out.print("Input the 2nd word being zipped: ");
        String secondZipped = keyboard.next();
        System.out.println(zipped(firstZipped,secondZipped));

        System.out.println();

        System.out.println(tabToSpace("Mo\ton", 10));

        System.out.println();

        System.out.print("Enter the word for containsAll: ");
        String containEverything = keyboard.next();
        System.out.print("Enter the word for containsAll check: ");
        String containCheck = keyboard.next();
        System.out.println("Comparing " + containEverything + " and " + containCheck + ": " + containsAll(containEverything, containCheck));

        System.out.println();

        System.out.print("Enter the word for indexOfAny: ");
        String indexAny = keyboard.next();
        System.out.println("Enter a character to check with thin the word " + indexAny + ": ");
        String chars = keyboard.next();
        System.out.println("The location of " + chars + " in " + indexAny + ": " + indexOfAny(indexAny, chars));

    }
}