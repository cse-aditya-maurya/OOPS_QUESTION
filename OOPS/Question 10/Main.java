
class BankTransactionProcessor {
	String record;
	BankTransactionProcessor(String record){
		this.record=record;
	}
	public String getAccountNumber(){
		int start=record.indexOf("ACC:")+5;
		int end=record.indexOf('|',start);

	}
}