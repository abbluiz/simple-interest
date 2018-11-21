import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // This will gather all the information from the user
        double principal, rate, term;
        String rateType, termUnit;

        System.out.println("Simple interest calculator\n");

        System.out.println("Provide principal amount: ");
        principal = input.nextDouble();

        System.out.println("\nProvide rate in percent followed by rate frequency (daily, monthly or yearly): ");
        rate = input.nextDouble();
        rateType = input.next();

        System.out.println("\nProvide length of time the interest will be applied for, followed by unit (days, months or years): ");
        term = input.nextDouble();
        termUnit = input.next();

        // Create SimpleInterest object
        SimpleInterest interest = new SimpleInterest(principal, rate, rateType, term, termUnit);

        // Print SimpleInterest object, which includes principal, rate, term and calculated simple interest and maturity value
        System.out.println("\n" + interest);

    }

}
