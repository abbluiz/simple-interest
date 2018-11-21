import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Date;

public class SimpleInterest {

    private double principal; // amount of initial value
    private double rate; // rate in percent
    private String rateType; // daily, monthly or yearly rates
    private double term; // term in days, months or years
    private String termUnit; // days, months or years

    // This constants specify the conversion between time units used in simple interest calculations
    private static final double DAYS_IN_A_MONTH = 30.0;
    private static final double DAYS_IN_A_YEAR = 365.0;
    private static final double MONTHS_IN_A_YEAR = 12.0;

    public SimpleInterest () {}

    public SimpleInterest (double principal, double rate, String rateType, double term, String termUnit) {

        this.principal = principal;
        this.rate = rate;
        this.rateType = rateType;
        this.term = term;
        this.termUnit = termUnit;

        this.setRateType(rateType); // Use setter to validate some values

    }

    // Getters
    public double getPrincipal () { return this.principal; }

    public double getRate () { return this.rate; }

    public String getRateType () { return this.rateType; }

    public double getTerm () { return this.term; }

    public String getTermType () { return this.termUnit; }


    // Setters
    public void setPrincipal (double principal) { this.principal = principal; }

    public void setRate (double rate) { this.rate = rate; }

    private void setRateType(String rateType) {

        /* Change "daily" to "days", "monthly" to "months, and "yearly" to "years"
         * This will make it easy to convert units later on */
        switch (rateType) {
            case "daily":
                this.rateType = "days";
                break;
            case "monthly":
                this.rateType = "months";
                break;
            case "yearly":
                this.rateType = "years";
                break;
        }

    }

    public void setTerm (double term) { this.term = term; }

    public void setTermType (String termUnit) { this.termUnit = termUnit; }

    /* This method will convert the term unit to whatever rate type is being used and return the converted result.
     * EXAMPLE: if it is a monthly interest rate and the term unit is days, this method will return the original term
     * value divided by the number of days in a month. */
    private double convertTermUnit() {

        if (this.rateType.equals(this.termUnit)) // Checks if the units are already compatible; if so returns the term as is
            return this.term;
        else if (this.rateType.equals("days") && this.termUnit.equals("months"))
            return (this.term * SimpleInterest.DAYS_IN_A_MONTH); // Return conversion from months to days
        else if (this.rateType.equals("days") && this.termUnit.equals("years"))
            return (this.term * SimpleInterest.DAYS_IN_A_YEAR); // Return conversion from years to days
        else if (this.rateType.equals("months") && this.termUnit.equals("days"))
            return (this.term / SimpleInterest.DAYS_IN_A_MONTH); // Return conversion from days to months
        else if (this.rateType.equals("months") && this.termUnit.equals("years"))
            return (this.term * SimpleInterest.MONTHS_IN_A_YEAR); // Return conversion from years to months
        else if (this.rateType.equals("years") && this.termUnit.equals("days"))
            return (this.term / SimpleInterest.DAYS_IN_A_YEAR); // Return conversion from days to years
        else if (this.rateType.equals("years") && this.termUnit.equals("months"))
            return (this.term / SimpleInterest.MONTHS_IN_A_YEAR); // Return conversion from months to years

        return 0.0;

    }

    public double calculateSimpleInterest() { return (this.principal * (this.rate / 100) * this.convertTermUnit()); }

    public double calculateMaturityValue() { return (this.principal + this.calculateSimpleInterest()); }

    @Override
    public String toString() {

        return "Principal: $" + this.principal + "\n" +
               "Interest rate: " + this.rate + "% " + SimpleInterestUtilities.interestRateTerminology(this.rateType) + "\n" +
               "Term: " + this.term + " " + this.termUnit + "\n" +
               "Simple interest: $" + SimpleInterestUtilities.round(this.calculateSimpleInterest(), 2) + "\n" +
                "Maturity value: $" + SimpleInterestUtilities.round(this.calculateMaturityValue(), 2);

    }

}
