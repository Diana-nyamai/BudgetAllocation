import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("How much can you spend? ");
        Scanner input = new Scanner(System.in);
        double budget = input.nextDouble();
        double sum = 0;
        int i = 0;
        ArrayList<Double> proportions = new ArrayList<>();
        System.out.println("Enter your proportion of various expenses");
        System.out.println("system stops if the cumulative proportions exceeds 100%");
        do {
            System.out.println("your proportion of expense " + (i+1) + ":");
            double value = input.nextDouble();
            proportions.add(value);
            sum+=proportions.get(i);
            i++;
        }while(sum<=100);
        input.close();
        if(sum>100){
            double cummulativesum = 0.0;
            for (int j=0; j<proportions.size() - 1; j++){
                cummulativesum = cummulativesum + proportions.get(j);
            }
            proportions.set(proportions.size()-1, 100.0-cummulativesum);
            for(double value:proportions){
                double expense = value*budget/100.0;
                System.out.println("your "+ value + "% equals ksh."+expense);
            }
        }
    }
}
