class Main {
	public static void main(String[] args) {
		PremiumRecharge pp=new PremiumRecharge(299,199,50);
		pp.calculateFinalAmount();
	}
}


class Recharge {
	private int amount;
	Recharge(int amount){
		this.amount=amount;
		System.out.println("Base recharge initialized: "+amount);
	}
	public int getAmount(){
		return amount;
	}
}

class DataRecharge extends Recharge {
	private int amount;
	DataRecharge(int baseAmount,int dataAmount){
		super(baseAmount);
		this.amount=dataAmount;
		System.out.println("Data pack added: "+baseAmount);
	}
	public int getAmount(){
		return super.getAmount()+amount;
	}

}

class PremiumRecharge extends DataRecharge {
	private int amount;
	PremiumRecharge(int baseAmount,int dataAmount,int taxAmount){
		super(baseAmount,dataAmount);
		this.amount=taxAmount;
		System.out.println("Service tax added: "+taxAmount);
	}
	public int calculateFinalAmount(){
		int afterData=super.getAmount();

		System.out.println("Amount after data pack: "+afterData);
		System.out.println("Final recharge amount calculated");
		int finalAmount=afterData+amount;
		System.out.println("Payble Amount: "+finalAmount);
		return finalAmount;
	}

}



