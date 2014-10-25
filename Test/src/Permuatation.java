import java.util.Arrays;


public class Permuatation {

	public static void main (String [] args){
		String[] a = {"1", "2", "3"};
		String[] b = {"4"};
		print(a, 1);
	}
	
	public static void print(Object[] a, String s){
		
	}
	
	public static void print(Object[] a, Object[] b){
		System.out.println(Permuatation.toString(a) + " " + Permuatation.toString(b));
		//if(a.length > 1)
		
		//print(a);
		String output = Permuatation.toString(b);
		if(a.length > 1){
			
		}
		
		
	}
	
	public static void print(Object[] a, int size){
	
		System.out.println(Permuatation.toString(a));
		
			Object[] a1 = null;
			Object[] a2 = null;;
			int rotation = a.length;
			while(rotation > 0){
			a1 = new Object[a.length - size];
			a2 = new Object[size];
		
			for(int i = 0; i < a1.length; i++){
				a1[i] = a[i];
			}
			for(int i = 0; i < a2.length; i++){
				a2[i] = a[a1.length  + i];
			}
				print(a1, a2);
				a = rotate(a);
				rotation--;
			//System.out.println(Permuatation.toString(a));
				
			}
			
			
			System.out.println(Permuatation.toString(a));
		}
		//print(a);
		
	
	
	public static Object[] concat(Object[] a, Object[] b){
		Object[] output = new Object[a.length + b.length];
		int i;
		for(i = 0; i < a.length; i++){
			output[i] = a[i];
		}
		for(i = 0; i < b.length; i++){
			output[i + a.length] = b[i];
		}
		//System.out.println(output);
		return output;
	}
	
	public static String toString(Object[] o){
		String output = "[";
		for(int i = 0; i < o.length; i++){
			if(i != o.length-1)
				output+=o[i] + ", ";
			else
				output+=o[i];
		}
		output += "]";
		
		return output;
	}
	
	public static Object[] rotate(Object[] o){
		Object temp = o[o.length-1];
		Object[] output = new Object[o.length];
		for(int i = 0; i < o.length - 1; i++){
			output[i+1] = o[i];
		}
		output[0] = temp;
		
		return output;
		
	}
	
}
