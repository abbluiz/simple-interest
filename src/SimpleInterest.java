import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Date;

public class SimpleInterest {

    private double principal;
    private double rate; // rate in percent
    private String rateType; // daily, monthly or yearly
    private double term; // term in days, months or years
    private String termUnit; // days, months or years

    public static final double DAYS_IN_A_MONTH = 30.0;
    public static final double DAYS_IN_A_YEAR = 365.0;
    public static final double MONTHS_IN_A_YEAR = 12.0;

    public SimpleInterest () {}

    public SimpleInterest (double principal, double rate, String rateType, double term, String termUnit) {

        this.principal = principal;
        this.rate = rate;
        this.rateType = rateType;
        this.term = term;
        this.termUnit = termUnit;

        this.setRateType(rateType);

    }

    public double getPrincipal () { return this.principal; }

    public double getRate () { return this.rate; }

    public String getRateType () { return this.rateType; }

    public double getTerm () { return this.term; }

    public String getTermType () { return this.termUnit; }

    public void setPrincipal (double principal) { this.principal = principal; }

    public void setRate (double rate) { this.rate = rate; }

    public void setRateType (String rateType) {

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

    private double convertTermUnit() {

        if (this.rateType.equals(this.termUnit))
            return this.term;
        else if (this.rateType.equals("days") && this.termUnit.equals("months"))
            return (this.term * SimpleInterest.DAYS_IN_A_MONTH);
        else if (this.rateType.equals("days") && this.termUnit.equals("years"))
            return (this.term * SimpleInterest.DAYS_IN_A_YEAR);
        else if (this.rateType.equals("months") && this.termUnit.equals("days"))
            return (this.term / SimpleInterest.DAYS_IN_A_MONTH);
        else if (this.rateType.equals("months") && this.termUnit.equals("years"))
            return (this.term * SimpleInterest.MONTHS_IN_A_YEAR);
        else if (this.rateType.equals("years") && this.termUnit.equals("days"))
            return (this.term / SimpleInterest.DAYS_IN_A_YEAR);
        else if (this.rateType.equals("years") && this.termUnit.equals("months"))
            return (this.term / SimpleInterest.MONTHS_IN_A_YEAR);

        return 0.0;

    }

    public double calculateSimpleInterest() { return (this.principal * (this.rate / 100) * this.convertTermUnit()); }

    public double calculateMaturityValue() { return (this.principal + this.calculateSimpleInterest()); }

    @Override
    public String toString() { return ""; }

}
