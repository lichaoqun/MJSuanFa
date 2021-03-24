
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>list = new SingleLineLinkedList<>();
		list.add(20);
		list.add(0, 10);
		list.add(30);
		list.add(list.size(), 40);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
	}

}
