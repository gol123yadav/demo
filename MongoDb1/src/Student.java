
public class Student {

	private String name;
	private int rollno;
	private float marks;
	
	public Student(String name,int rollno,float marks) {
	
		this.name=name;
		this.rollno=rollno;
		this.marks=marks;
		
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("name: "+getName());
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
		System.out.println("Rollno: "+getRollno());
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
		System.out.println("marks: "+getMarks());
	}
	
	
	
	
}
