class Node{
	int data;
	Node next;
	Node prev;
	public Node(int data){
		this.data = data;
	}
}
class queuell{
	Node front;
	Node rear;
	Node head=null;
	int qlen = -1,max=5;
	public void enqueue(int x){
		Node newnode = new Node(x);
		if(qlen == max)
			System.out.println("Full Q");
		else{
			if(head==null){
				head = newnode;
				rear = head;
				front = rear;
			}
			else if(rear == front){
				front.prev = newnode;
				newnode.next = rear;
				rear = newnode;
			}
			else{
				rear.prev = newnode;
				newnode.next = rear;
				rear = newnode;
			}
			qlen++;
		}
	}
	public void dequeue(){
		if(qlen == -1)
			System.out.println("Empty Q");
		else{
			front = front.prev;
			qlen--;
		}

	}
	public void peek(){
		System.out.println(front.data);
	}
	public static void main(String args[]){
		queuell q = new queuell();
		q.enqueue(9);
		q.enqueue(10);
		q.enqueue(23);
		q.peek();
		q.dequeue();
		q.peek();
		q.dequeue();
		q.peek();

	}
}