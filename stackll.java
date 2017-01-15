class Node{
	int data;
	Node next;
	Node prev;
	public Node(int data){
		this.data = data;
	}
}
class stackll{
	Node top;
	Node prevtop;
	Node head=null;
	int topcount = -1,max=5;
	public void push(int x){
		Node newnode = new Node(x);
		if(topcount == max)
			System.out.println("Full stack");
		else{
			if(head==null){
				head = newnode;
				top = head;
			}
			else{
				prevtop = top;
				top.next = newnode;
				top = newnode;
				top.prev = prevtop;
			}
			topcount++;
		}
	}
	public void pop(){
		if(topcount == -1)
			System.out.println("Empty Stack");
		else{
			top = top.prev;
			topcount--;
		}

	}
	public void peek(){
		System.out.println(top.data);
	}
	public static void main(String args[]){
		stackll s = new stackll();
		s.push(10);
		s.push(11);
		s.push(349);
		s.push(890);
		s.peek();
		s.pop();
		s.pop();
		//s.pop();
		s.peek();

	}
}