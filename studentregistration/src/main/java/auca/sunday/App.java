package auca.sunday;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int addTwoNumber(int a, int b){
        return a + b;
    }

    public String Gender_Age(String gender, int age){
        if (age <= 0) {
            return "Incorrect input";
        }
        
        if ((age < 8) && (gender.equalsIgnoreCase("female"))){
            return "Hello baby girl";
        } else if ((age < 8) && (gender.equalsIgnoreCase("male"))){
            return "Hello baby boy";
        }else if ((age < 18) && (gender.equalsIgnoreCase("female"))){
            return "Hello young lady";
        }else if ((age < 18) && (gender.equalsIgnoreCase("male"))){
            return "Hello young boy";
        }else if ((age < 35) && (gender.equalsIgnoreCase("female"))){
            return "Hello my lady";
        }else if ((age < 35) && (gender.equalsIgnoreCase("male"))){
            return "Hello my man";
        }else if ((age >= 35) && (gender.equalsIgnoreCase("female"))){
            return "Hello maam";
        }else if ((age >= 35) && (gender.equalsIgnoreCase("male"))){
            return "Hello Sir";
        }

        return null;
    }


    // Grading system that takes the list (array) of marks you get from different course then find the average
    // 40,50,80,90,87
    // average is greater than 90 grand  "A"
    // average is greater then or equal 80 and less than 90 "B"
    // average is greater than or equal 70 and less than 80 "c"
    // average is greater than or equal 60 and less than 70 "D"
    // average is greater than or equal 50 and less than 60 "E"
    // average is less than 50 "F"

    public String GradingSystem(int[] marks) {
        if (marks.length <= 0) {
            return "Invalid input";
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }

        double average = sum / (double) marks.length;

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else if (average >= 50) {
            return "E";
        } else {
            return "F";
        }
    }


    // Write method which accepts an array of integers and returns an array of even numbers only.
    public int[] EvenArray(int[] arr) {
        if (arr.length <= 0) {
            return new int[0];
        }

        int count = 0;
        for (int number : arr) {
            if (number % 2 == 0) {
                count++;
            }
        }

        int[] evenNumbers = new int[count];
        int index = 0;
        for (int number : arr) {
            if (number % 2 == 0) {
                evenNumbers[index++] = number;
            }
        }

        return evenNumbers;
    }

}
