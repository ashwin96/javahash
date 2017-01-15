class Node{
	int data;
	Node next;
	Node previous;
	public Node(int data){
		this.data = data;
	}
}
class linkedlist{
	Node first;
	Node temp;
	Node prev;
	public linkedlist(){
		first = null;
		prev = null;
	}
	public Node newnode(int data){
		Node newnode = new Node(data);
		newnode.next = null;
		newnode.previous = null;
		return newnode;
	}
	public void insert(int data){
		Node t = newnode(data);
		if(first  == null)
			first = t;
		else {
			traverse();
			temp.next = t;
			t.previous = temp;
		}
	}
	public void traverse(){
		temp  = first;
		while(temp.next != null){
			prev = temp;
			temp = temp.next;
		}
	}
	public void delete(int data){
		temp  = first;
		while(temp.next != null && temp.data != data){
			prev = temp;
			temp = temp.next;
		}
		if(temp.next == null)
			System.out.println("no such val");
		else if (temp.data == data)
			{
				System.out.println("val deleted:"+temp.data);
				prev.next = temp.next;
				temp.next.previous = prev;
			}
	}
	public void insertaspos(int data,int pos){
		Node t = newnode(data);
		if(pos == 1)
			if(first == null)
				first = t;
			else{
				t.next = first;
				first = t;
			}
			else{
				temp = first;
				int c = 1;
				while(temp.next != null && c != pos){
					prev = temp;
					temp = temp.next;
					c++;
				}
				if(c == pos){
					prev.next = t;
					t.next = temp;
					t.previous = prev;
					temp.previous = temp;
				}
				else if (c+1 == pos)
					{
					temp.next = t;
					t.previous = temp;
				}				
				else
					System.out.println("Pos. out of range");
			}
	}
	public void display(){
		temp = first;
		while(temp != null){
			System.out.println(temp.data);
			prev = temp;
			temp = temp.next;
		}
		/*temp  = prev;
		while(temp != first){
			System.out.println(temp.data);
			temp = temp.previous;
		}*/

	}
public static void main(String args[]){
	linkedlist l = new linkedlist();
	l.insert(9);
	l.insert(7);
	l.insert(3);
	l.insertaspos(5,4);
	l.insertaspos(20,2);
	l.display();
	System.out.println();
	l.delete(3);
	l.delete(20);
	l.display();
}
}