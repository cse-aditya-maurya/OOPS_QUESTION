import java.util.*;
class Main {
	public static void main(String[] args) {
		HashSet<Booking> hh=new HashSet<>();
		Passenger p1=new Passenger("Ravi","P123");
		Booking b1=new Booking(p1,9001);
		hh.add(b1);
		System.out.println(hh.size());
		System.out.println(hh);
	}
}

class Passenger {
	String name;
	String passportNo;
	Passenger(String name,String passportNo){
		this.name=name;
		this.passportNo=passportNo;
	}

}


class Booking{
	int bookingId;
	Passenger passenger;
	Booking(Passenger passenger,int bookingId){
		this.passenger=passenger;
		this.bookingId=bookingId;
	}
	@Override 
	public boolean equals(Object obj){
		if(this==obj) return true;
		if(obj==null) return false;
		if(!(obj instanceof Booking)) return false;
		Booking other=(Booking)obj;
		return this.bookingId==other.bookingId;

	}
	@Override 
	public int hashCode(){
		return bookingId;
	}

	@Override
	public String toString(){
		return "Booking[id="+bookingId+", passenger="+passenger.name+"]";
	}

}