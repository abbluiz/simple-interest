import java.util.Date;

public class SimpleInterest {

    private double principal;
    private double rate; // rate in percent
    private String rateType; // daily, monthly or yearly rate
    private double term; // term in days, months or years

    public SimpleInterest () {}

    public SimpleInterest (double principal, double rate, String rateType, double term) {

        this.principal = principal;
        this.rate = rate;
        this.rateType = rateType;
        this.term = term;

    }

    public double getPrincipal () { return this.principal; }

    public double getRate () { return this.rate; }

    public String getRateType () { return this.rateType; }

    public double getTerm () { return this.term; }

    public void setPrincipal (double principal) { this.principal = principal; }

    public void setRate (double rate) { this.rate = rate; }

    public void setRateType (String rateType) { this.rateType = rateType; }

    public void setTerm (double term) { this.term = term; }

    public double calculateSimpleInterest() { return (this.principal * (this.rate / 100) * this.term); }

    public double calculateMaturityValue() { return (this.principal + this.calculateSimpleInterest()); }

    @Override
    public String toString() { return ""; }

}
