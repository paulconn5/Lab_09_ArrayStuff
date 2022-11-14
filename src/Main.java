import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lab 1
        int[] dataPoints = new int[100];
        Scanner in = new Scanner(System.in);

        int sum = 0;
        double average = 0;

        Random rnd = new Random();

        for (int i=0; i<100; i++) {
            dataPoints[i] = rnd.nextInt(100)+1;
            // Print Loop
            System.out.print(dataPoints[i] + " | ");

            //Sum
            sum = sum + dataPoints[i];


        }
        //Count how many times a number appears
        int getCount = getRangedInt(in, "Enter a value to search for: ", 1, 100);
        int count = 0;
        for (int i=0; i<100; i++) {
            if (dataPoints[i] == getCount) {
                count = count + 1;
            }
        }
        System.out.println("The number " + getCount + " was found " + count + " many times.");

        //Find the position of a number
        boolean found = false;
        int checkValue = getRangedInt(in, "Enter a value to search for: ", 1, 100);
        for (int i=0; i<100; i++) {
            if (dataPoints[i] == checkValue) {
                System.out.println("\nThe check value of " + checkValue + " was found at position " + i+1);
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("\nThe check value of " + checkValue + " is not in the array.");
        }

        //Find min and max
        int min = 100;
        int max = 0;
        for (int i=0; i<100; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum is:  " + min + " and the max is: " + max);



        //Average
        average = sum/100;
        System.out.println("\nThe sum of the array is: " + sum + "\nThe average of the array is: " + average);

        //Fancy Average
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        int retInt = 0;
        do {
            System.out.print("\n" + prompt + low + "-" + high + ": "); // show prompt add space
            if(pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                if (retInt >= low && retInt <= high) {
                    done = true;
                }
                else {
                    System.out.println("You must enter an integer between " + low + "-" + high);
                }
            } else {
                System.out.println("You must enter an integer.");
            }
            pipe.nextLine();
        }while(!done);
        return retInt;
    }

    public static double getAverage(int values[]){
            int sum = 0;
            double average = 0;
            for (int i = 0; i < values.length; i++) {
                sum = sum + values[i];
            }
            average = sum/values.length;
            return average;
    }

}