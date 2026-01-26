class Main {
	public static void main(String[] args) {
		Passenger p1=new Passenger("Ravi");
		Booking b1=new Booking(p1,2000,300);
		b1.displayBooking();
		Passenger p2=new Passenger("Anita");
		PremiumBooking p3=new PremiumBooking(p2,2500,400,300,500);
		p3.displayBooking();
	}
}

class Passenger {
	private String name;
	Passenger(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}

class Booking {
	private double basePrice;
	private double seatCharge;
	private double mealCharge;
	Passenger passenger;
	Booking(Passenger passenger,double basePrice){
		this.passenger=passenger;
		this.basePrice=basePrice;

	}
	Booking(Passenger passenger,double basePrice,double seatCharge){
		this(passenger,basePrice);
		this.seatCharge=seatCharge;
	}

	Booking(Passenger passenger,double basePrice,double seatCharge,double mealCharge){
		this(passenger,basePrice,seatCharge);
		this.mealCharge=mealCharge;
	}


	public double getTotalCost(){
     return basePrice+seatCharge+mealCharge;
	}

	public void displayBooking(){
		System.out.println("Passenger: "+passenger.getName());
     System.out.println("Total Booking cost: "+getTotalCost());

	}
}


class PremiumBooking extends Booking {
	double premiumCharge;
	PremiumBooking(Passenger passenger, double basePrice, double premiumCharge){
		super(passenger,basePrice);
		this.premiumCharge=premiumCharge;
	}

	   public PremiumBooking(Passenger passenger, double basePrice,
                          double seatCharge, double mealCharge, double premiumCharge) {
        super(passenger, basePrice, seatCharge, mealCharge);
        this.premiumCharge = premiumCharge;
    }
    @Override
	public double getTotalCost(){
		double total=super.getTotalCost();
		if(total>3000){

			 total+=premiumCharge;
		} 
		return total;
	}


}