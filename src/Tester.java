import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double principal, rate, term;
        String rateType, termUnit;

        System.out.println("Simple interest calculator\n");

        System.out.println("Provide principal amount: ");
        principal = input.nextDouble();

        System.out.println("\nProvide interest rate frequency (daily, monthly or yearly): ");
        rateType = input.next();

        System.out.println("\nProvide rate in percent: ");
        rate = input.nextDouble();

        System.out.println("\nProvide length of time the interest will be applied for, followed by unit (days, months or years): ");
        term = input.nextDouble();
        termUnit = input.next();

        SimpleInterest interest = new SimpleInterest(principal, rate, rateType, term, termUnit);

        System.out.println("\nSimple interest: $" + interest.calculateSimpleInterest());
        System.out.println("\nMaturity value: $" + interest.calculateMaturityValue());

    }

}
