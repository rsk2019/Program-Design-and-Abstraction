/*
 * Rafid Karim
 * Assignment 4: Nest Egg
 * We use the Scanner method and calculate compound interest
 */
package assignment5;
import java.util.Scanner;
import java.util.Formatter;

public class InterestCalculator {
    public static int MONTHS = 12;
    public static int DAYS = 365;
    public static double YearlyInterest(double in_bal, double yearly_rate, int years){
        
        double amount = Math.pow((1 + yearly_rate/100), years)*in_bal;
            
        return(amount);
    }
    
    public static double MonthlyInterest(double in_bal, double yearly_rate, int years ){
        double amount = Math.pow((1 + 0.01*yearly_rate/MONTHS), years*MONTHS)*in_bal;
        return(amount);
    }
    
    public static double DailyInterest(double in_bal, double yearly_rate, int years ){
        double amount = Math.pow((1 + 0.01*yearly_rate/DAYS), years*DAYS)*in_bal;
        return(amount);
    }
    
    
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.print("What is the starting balance (in dollars)? ");
        double in_bal = user_input.nextInt();
        
        System.out.print("What's the yearly interest rate (in percent)? ");
        double yearly_rate = user_input.nextInt();
        
        System.out.print("For how many years will you be saving? ");
        int years = user_input.nextInt();
        System.out.println();

        System.out.println("Using: starting balance - " + in_bal);
        System.out.println("yearly interest rate - " + yearly_rate);
        System.out.println("years to save - " + years);
        System.out.println();
        
        for(int i=1; i<=years; i++){
                double yearlyAmount = YearlyInterest(in_bal, yearly_rate, i);
                double monthlyAmount = MonthlyInterest(in_bal, yearly_rate, i);
                double dailyAmount = DailyInterest(in_bal, yearly_rate, i);
                System.out.format("|%6d|$%.2f|$%.2f|$%.2f|\n", i, yearlyAmount, monthlyAmount, dailyAmount);   
            
        }
    }
    
}
