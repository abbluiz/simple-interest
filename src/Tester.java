import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double principal, rate, term;
        String rateType;

        System.out.println("Simple interest calculator\n");

        System.out.print("Provide principal amount: ");
        principal = input.nextDouble();

        System.out.print("Provide interest frequency (daily, monthly or yearly): ");
        rateType = input.next();

        System.out.print("Provide rate in percent: ");
        rate = input.nextDouble();

        System.out.print("Provide length of time the interest will be applied for: ");
        term = input.nextDouble();

        SimpleInterest interest = new SimpleInterest(principal, rate, rateType, term);

        System.out.println("\nSimple interest: " + interest.calculateSimpleInterest());
        System.out.println("\nMaturity value: " + interest.calculateMaturityValue());

    }

}
