/*
Rafid Karim
09/14/2017
Assignment 3
In this assignment, we are using loops to repeat lines of code to create the
Lincoln Financial Field and Parking Lot
 */
package assignment3;


public class AsciiArt {
    public static final int SIZE = 5; // Changes the size of the triangles produced.
    public static final int REPS = 2; // changes the number of triangles produced vertically
                                      // if its set to 1, then 2 triangles of opposite 
                                      // sides will be produced. Has to be greater than 0.
    public static final int SIZE_OF_T = 5;
    public static void triangle(){
        //creates the first half of the triangle
        for (int n=1; n<=REPS; n++){           
            for (int i=1; i<=SIZE; i++){
                System.out.print("*");

                for (int j=1; j<=i; j++){
                    System.out.print(("*"));

            }
                System.out.println();
            } 
            //starts to produce a capital T
            for(int f=1; f<=SIZE; f++){
                System.out.print("-");
            }
            System.out.println();
            
            for(int t=1; t<=SIZE_OF_T; t++){
                for(int k=1; k<=SIZE/2 ; k++){
                    System.out.print(" ");
                }
                
                System.out.println("|");
            }
            //creates the second half of the triangle
            for (int i=1; i<=SIZE; i++){
                System.out.print("*");

                for (int j=1; j<=SIZE-i; j++){
                    System.out.print(("*"));

            }
                System.out.println();
            }  
        }
    }
    public static void main(String[] args) {
        triangle();
        System.out.println();
    
}
}
