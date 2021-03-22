
public class Person {
	private int mAge;
	private String mName;
	public Person(int mAge, String mName) {
		super();
		this.mAge = mAge;
		this.mName = mName;
	}
	
	@Override
	public String toString() {
		return "Person [mAge=" + mAge + ", mName=" + mName + "]";
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Person finalize" + this);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Person person = (Person) obj;
		return (person.mName == this.mName && person.mAge == this.mAge);
	}
	
}