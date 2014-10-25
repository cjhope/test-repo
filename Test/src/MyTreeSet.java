import java.util.TreeSet;

public class MyTreeSet<E> extends TreeSet {

	
	public static void main (String [] args){
		TreeSet<int[]> t = new TreeSet<int[]>();
		int[] a1 = {1, 2, 3};
		int[] a2 = {2, 3, 4};
		t.add(a1);
		t.add(a2);
		
		System.out.println(t);
	}
	
	
	
}
