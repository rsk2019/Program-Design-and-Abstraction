/*
 * Rafid Karim
 * Assignment 5: Grade Calculator
 * Rhis program calculates the grade of a student using weights and curves.
 */
package assignment5;
import java.util.Scanner;

public class Grades {
    public static int HWPOINTS = 10;
    public static int LABPOINTS = 4;
    public static int EXAMPOINTS = 100;

    public static double weightedHomeworkScore(double homeworkPoints, double homeworkTotal, int homeworkWeight){
        double weightedScore = (homeworkPoints/homeworkTotal) * homeworkWeight;
        return (weightedScore);
    
    }
    
    public static double lateDayChange(int lateDays, int num_assignments, double homeworkPoints, double homeworkTotal){
        if(lateDays >= num_assignments/2){
            homeworkPoints = 0.9*homeworkPoints;
        }
        else if(lateDays == 0 ){
            homeworkPoints = homeworkPoints + 5;
        }
            if(homeworkPoints>homeworkTotal){
                homeworkPoints = homeworkTotal;
            }    
        return(homeworkPoints);
    }
    
    public static double pointsExam(double examScore, double examCurve){
        double exam1Points = examScore + examCurve;
        if(exam1Points>EXAMPOINTS){
            exam1Points=EXAMPOINTS;
        }
        return (exam1Points);
    }
    
    public static double weightedExamScore(double examScore, int examWeight){
        double weightedScore = (examScore/EXAMPOINTS) * examWeight;
        return (weightedScore);
    }

    public static void main(String[] args) {
        
        Scanner user_input = new Scanner(System.in);
        
        System.out.println("This program accepts your homework and two exam scores as input and computes your grade in the course.");
        System.out.println("Homework weight? ");
        int homeworkWeight = user_input.nextInt();
        System.out.println("Exam 1 weight? ");
        int exam1Weight = user_input.nextInt();
        int exam2Weight = 100 - homeworkWeight - exam1Weight;
        
        System.out.println("Using weights of " + homeworkWeight + " " + exam1Weight + " " + exam2Weight);
        System.out.println("Number of Assignments? ");
        int num_assignments = user_input.nextInt();
        System.out.println("Average homework grade? ");
        double avg_hw = user_input.nextDouble();
        if(num_assignments<=0){
            avg_hw = HWPOINTS;
        }
        if(avg_hw<0){
            avg_hw=0;
        }
        System.out.println("Number of late days used? ");
        int lateDays = user_input.nextInt();
        System.out.println("Labs attended? ");
        int labAttendance = user_input.nextInt();
        
        double homeworkTotal = num_assignments*HWPOINTS + num_assignments*LABPOINTS;
        double homeworkPoints = num_assignments*avg_hw + labAttendance*LABPOINTS;
        
        homeworkPoints = lateDayChange(lateDays, num_assignments, homeworkPoints, homeworkTotal);
        
        System.out.println("Total Points = " + homeworkPoints + " / " + homeworkTotal);
        System.out.printf("weighted Score: %.2f", weightedHomeworkScore(homeworkPoints, homeworkTotal, homeworkWeight));
        System.out.println();
        
        System.out.println("Exam 1:");
        System.out.println("Score? ");
        double exam1Score = user_input.nextDouble();
        if(exam1Score>EXAMPOINTS) exam1Score=EXAMPOINTS;
        System.out.println("Curve?");
        double exam1Curve = user_input.nextDouble();
        exam1Score = pointsExam(exam1Score, exam1Curve);
        System.out.println("Total Points = " + exam1Score + " / " + EXAMPOINTS);
        System.out.printf("Weighted Score = %.2f", weightedExamScore(exam1Score, exam1Weight));
        System.out.println();
        
        System.out.println("Exam 2:");
        System.out.println("Score? ");
        double exam2Score = user_input.nextDouble();
        if(exam2Score>EXAMPOINTS) exam2Score=EXAMPOINTS;
        System.out.println("Curve?");
        double exam2Curve = user_input.nextDouble();
        exam2Score = pointsExam(exam2Score, exam2Curve);
        System.out.println("Total Points = " + exam2Score + " / " + EXAMPOINTS);
        System.out.println("Weighted Score = " + weightedExamScore(exam2Score, exam2Weight));
        System.out.println();
        
        double grade = weightedHomeworkScore(homeworkPoints, homeworkTotal, homeworkWeight) + weightedExamScore(exam1Score, exam1Weight) + weightedExamScore(exam2Score, exam2Weight);
        System.out.printf("Course Grade = %.2f", grade);
        
    }
    
}
