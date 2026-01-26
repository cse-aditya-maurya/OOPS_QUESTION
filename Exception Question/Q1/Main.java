class Main {
	public static void main(String[] args) {
		TaxPayer taxpayer=new BusinessTaxPayer(-75000);
		try{
			 taxpayer.calculateTax();
		}
		catch(InvalidIncomeException | TaxComputationException e){
			System.out.println("Tax Calulation Error");
			System.out.println(e.getMessage());

		}

	}
}

abstract class TaxPayer {
	double income;
	TaxPayer(double income){
		this.income=income;
	}
	abstract double calculateTax() throws InvalidIncomeException,TaxComputationException;

}

class SalariedTaxPayer extends TaxPayer {
	SalariedTaxPayer(double income){
		super(income);
	}

	@Override 
	public double calculateTax()
		throws InvalidIncomeException,TaxComputationException{
		return TaxCalculator.computeTax(income);
	}
	}


class BusinessTaxPayer extends TaxPayer {
	BusinessTaxPayer(double income){
		super(income);
	}
	@Override 
	public double calculateTax()
		throws InvalidIncomeException,TaxComputationException{
		return TaxCalculator.computeTax(income);
	}
	
	
}

class TaxCalculator {
    public static double computeTax(double income)
            throws InvalidIncomeException, TaxComputationException {

        if (income < 0)
            throw new InvalidIncomeException("Income cannot be negative.");

        double tax;

        if (income <= 250000) {
            tax = 0;
        } else if (income <= 500000) {
            tax = (income - 250000) * 0.05;
        } else if (income <= 1000000) {
            tax = (250000 * 0.05) + (income - 500000) * 0.20;
        } else {
            tax = (250000 * 0.05)
                + (500000 * 0.20)
                + (income - 1000000) * 0.30;
        }

        if (tax < 0)
            throw new TaxComputationException("Invalid tax computation");

        return tax;
    }
}

class InvalidIncomeException extends Exception {
	public InvalidIncomeException(String s){
		super(s);
	}
}

class TaxComputationException extends Exception {
	public TaxComputationException(String s){
		super(s);
	}
}
