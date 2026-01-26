class Main {
	public static void main(String[] args) {
		CityDriver cc=new CityDriver("Ramesh","CITY123");
		HighWayDriver hh=new HighWayDriver("Suresh","HIGHWAY456");
		cc.duty();
		hh.duty();
	}
}

class Person {
	private String name;
	Person(String name){
		this.name=name;
		System.out.println("Person registered: "+name);
	}
	public String getName(){
		return name;
	}
}

class Driver extends Person{
	private String lincense;
	Driver(String name,String lincense){
		super(name);
		this.lincense=lincense;
		System.out.println("Driver lincenced: "+lincense);
	}
	public void commonDuty(){
		System.out.println(getName()+" is checking vechicle");
	}
	public void duty(){

	}

}

class CityDriver extends Driver {
	CityDriver(String name,String lincense){
		super(name,lincense);
	}
	@Override
	public void duty(){
		commonDuty();
      System.out.println(getName()+" driving in city traffic");
	}
}


class HighWayDriver extends Driver {
	HighWayDriver(String name,String lincense){
		super(name,lincense);
	}
	@Override
	public void duty(){
		commonDuty();
		System.out.println(getName()+" driving on highway");
	}
}

