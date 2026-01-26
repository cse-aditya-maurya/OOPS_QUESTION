class Main {
	public static void main(String[] args) {
		Student st=new Student("Anita");
		Result rr=new Result(35);
		ExamSession ee=new ExamSession(st,rr);
		ee.evaluate();
		
	}
}

class Student {
	private String name;
	Student(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}

class Result {
	int marks;
	Result(int marks){
		this.marks=marks;
	}
	public boolean isPass(){
		return marks>=40;
	}

}


class ExamSession {
	Student student;
	Result result;
	ExamSession(Student student,Result result){
		this.student=student;
		this.result=result;
	}

	public void evaluate(){
		if(result.isPass()){
			System.out.println(student.getName()+" passed the exam");
		}
		else {
			System.out.println(student.getName()+" failed the exam");
		}
	}

}