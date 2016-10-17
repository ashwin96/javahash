import java.util.*;
class hash{
	static String[]  table;
	static int  max;
	public static void settable(){
		table = new String[max];
		for(String i:table)
			i=null;
	}
	public static void main(String args[]){
		String s = "abcdefgh";
		String s1 = "enfadkfjd";
		Scanner sc = new Scanner(System.in);
		max = 8;
		//System.out.println((s.hashCode()& 0x7fffffff )%max);
		//System.out.println((s1.hashCode() & 0x7fffffff )%max);
		settable();
		int count=5;
		while(count > 0){
			//val = sc.next();
			hash(sc.nextLine());
			count--;
		}
		System.out.println("Entered successfully");
		for(String j:table)
			System.out.println(j);
		System.out.println("Enter item to search");
		System.out.println(search(sc.next()));
	}
	public static void hash(String s){
		int key = (s.hashCode() & 0x7fffffff)%max;
		int i=key;
		int temp =key;
		do{
			if(table[key]==null)
				{table[key]=s;System.out.println(" :into "+key);return;}
			else if(table[key].equals(s))
				{System.out.println("duplicate val");return;}
			else{
				System.out.println("cur key: "+key);
				key = (i + (i*i++))%max;
				System.out.println("next key: "+key);
			}
		}while(temp!=key);
		
	}
	public static boolean search(String s){
		int key = (s.hashCode()& 0x7fffffff)%max;
		int temp=key;
		int i=key;
		do{
			if(table[key].equals(s)){
				System.out.println("Found in :"+key);
				return true;
			}
			else
				key = (i+(i*i++))%max;
		}while(table[key]!=null);
		return false;	
	}
}