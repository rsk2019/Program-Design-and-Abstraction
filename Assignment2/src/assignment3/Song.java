/*
Rafid Karim
Assignment 2: Song
09/07/2017
This assignment provides insight on using static methods and println. We create 
a bunch of methods to prevent reiteration of redundant lines of a song.
 */
package assignment3;

public class Song {
    public static void cat(){
        System.out.println("Cat goes fiddle-i-fee.");
    }
    public static void hen(){
        System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
    }
    public static void duck(){
        System.out.println("Duck goes quack, quack,");
    }
    public static void goose(){
        System.out.println("Goose goes hissy, hissy,");
    }
    public static void sheep(){
        System.out.println("Sheep goes baa, baa,");
    }
    public static void pig(){
        System.out.println("Pig goes oink, oink,");
    }
    public static void line1(){
        System.out.println("Bought me a cat and the cat pleased me,");
        System.out.println("I fed my cat under yonder tree.");
        cat();
    }
    public static void line2(){
        System.out.println("Bought me a hen and the hen pleased me,");
        System.out.println("I fed my hen under yonder tree.");
        hen();
        cat();
    }
    public static void line3(){
        System.out.println("Bought me a duck and the duck pleased me,");
        System.out.println("I fed my duck under yonder tree.");
        duck();
        hen();
        cat();
    }
    public static void line4(){
        System.out.println("Bought me a goose and the goose pleased me,");
        System.out.println("I fed my goose under yonder tree.");
        goose();
        duck();
        hen();
        cat();
    }
    public static void line5(){
        System.out.println("Bought me a sheep and the sheep pleased me,");
        System.out.println("I fed my sheep under yonder tree.");
        sheep();
        goose();
        duck();
        hen();
        cat();
    }
    public static void line6(){
        System.out.println("Bought me a pig and the pig pleased me,");
        System.out.println("I fed my pig under yonder tree.");
        pig();
        sheep();
        goose();
        duck();
        hen();
        cat();
    }
    public static void main(String[] args) {
        line1();
        System.out.println();
        line2();
        System.out.println();
        line3();
        System.out.println();
        line4();
        System.out.println();
        line5();
        System.out.println();
        line6();
    }
}
