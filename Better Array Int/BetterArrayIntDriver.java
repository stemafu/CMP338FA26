
public class BetterArrayIntDriver {

	public static void main(String[] args) {
		
		
		BetterArrayInt list = new BetterArrayInt();
		System.out.println("This should a 0 ?"+ list.size());
		System.out.println("This shou;ld be true ? " + list.isEmpty());
		list.add(90);
		list.add(80);
		list.add(40);
		list.add(70);
		list.add(10);
		list.add(15);
		
		list.add(100, 1000);
		System.out.println("This should a 7 ? "+ list.size());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("index " + i + " has " + list.get(i));
		}
		
		list.add(33, 4);
		for(int i = 0; i < list.size(); i++) {
			System.out.println("index " + i + " has " + list.get(i));
		}
		
		System.out.println("This should a 8 ? "+ list.size());
		
		/*System.out.println(list.get(0));
		
		System.out.println(list.size());
		
		for(int i = 0; i < 1_000; i++) {
			list.add(i);
		}
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		System.out.println();
		for(int i = 0; i < 1_006; i++) {
			System.out.println(list.get(i));
		}*/

	}

}
