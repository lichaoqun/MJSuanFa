

public class Main {

	public static void main(String[] args) {
		
		// - Person类型
		ArrayList <Person> personArrayList = new ArrayList<>();
		personArrayList.add(new Person(10, "Jack"));
		personArrayList.add(new Person(20, "James"));
		personArrayList.add(new Person(30, "Rose"));
		System.out.println(personArrayList);
		
		// - 查找指定obj的索引
		Person objPerson = new Person(30, "Rose");
		System.out.println(personArrayList.indexOf(objPerson));

		// - 清空
		personArrayList.clear();
		System.gc();

		// - Integer类型
		ArrayList<Integer>intsArrayList = new ArrayList<>();
		intsArrayList.add(10);
		intsArrayList.add(30);
		intsArrayList.add(50);
		System.out.println(intsArrayList);
		
		// - double类型
		ArrayList<Double>floatsArrayList = new ArrayList<>();
		floatsArrayList.add(0.1);
		floatsArrayList.add(0.3);
		floatsArrayList.add(0.5);
		System.out.println(floatsArrayList);
	}
}
