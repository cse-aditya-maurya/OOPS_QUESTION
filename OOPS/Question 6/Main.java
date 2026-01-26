class Main {
	public static void main(String[] args) {
		Driver dd=new Driver("Ramesh",true);
		Payment p1=new Payment(true);

		Ride r1=new Ride(101,dd,p1);
		r1.startRide();
		Payment p2=new Payment(true);
		Ride r2=new Ride(102,dd,p2);
		r2.startRide();


	}
}

class Driver {
	private String name;
	boolean available;
	Driver(String name,boolean available){
		this.name=name;
		this.available=available;
	}
	public boolean isAvaiable(){
		return available;
	}
	public void markUnavaible(){
		available=false;
	}
	public String getName(){
		return name;
	}


}

class Payment {
	boolean successful;
	Payment(boolean successful){
		this.successful=successful;
	}
	public boolean isSuccessful(){
		return successful;
	}

}


class Ride {
	int rideId;
	Driver driver;
	Payment payment;
	Ride(int rideId,Driver driver,Payment payment){
		this.rideId=rideId;
		this.driver=driver;
		this.payment=payment;
	}
	public void startRide(){
		if(driver.isAvaiable() && payment.isSuccessful()){
			driver.markUnavaible();
		
		System.out.println("Ride "+rideId+" started with driver "+driver.getName());
	}
	 else {
		System.out.println("Ride "+rideId+" failed");
	}
}}
