
public class MyDLLImpl<E> implements MyDoubleLinkedList {

	private MyDoubleNode head, tail;
	private int size;

	// Constructor Implementation:
	public MyDLLImpl() {
		Object dummyObj = new Object();
		head = new MyDoubleNode(dummyObj, null, null);
		tail = new MyDoubleNode(dummyObj, null, null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	@Override
	public void insert(Object x) {
		if (this.lookup(x)) {
			System.out.println("duplicated data, not inserted");
		} else {
			MyDoubleNode newNode = new MyDoubleNode(x, tail, tail.prev);

			tail.prev.next = newNode;
			tail.prev = newNode;
			size++;
			System.out.println("new item added: " + x);
		}

	}

	public void insert(Object x, MyDoubleNode p) {
		if (this.lookup(x)) {
			System.out.println("duplicated data, not inserted");
		} else {
			MyDoubleNode newNode = new MyDoubleNode(x, p.next, p);
			p.next = newNode;
			p.next.prev = newNode;
			size++;
			System.out.println("new item added: " + x);
		}
	}

	@Override
	public void delete(Object x) {
		if (this.lookup(x)) {
			MyDoubleNode current = head;
			while (current != tail) {
				if (current.data == x) {
					break;
				}
				current = current.next;
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;
			size--;
			System.out.println("Item was deleted:" + x);
		} else {
			System.out.println("Item not found, not deleted");
		}
	}

	@Override
	public boolean lookup(Object x) {
		// TODO Auto-generated method stub
		MyDoubleNode current = head;
		while (current != null) {
			if (current.data == x) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void printList() {
		MyDoubleNode current = head;
		while (current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	@Override
	public void printListRev() {
		MyDoubleNode current = tail;
		while (current.prev != null) {
			System.out.println(current.data);
			current = current.prev;
		}

	}

	public static void main(String a[]) {
		MyDLLImpl<Integer> dll = new MyDLLImpl<Integer>();
		dll.insert(10);
		dll.insert(34);
		dll.insert(56);
		dll.insert(364);
		dll.printList();
		dll.delete(56);
		dll.delete(33);
		dll.printListRev();
	}

}

// worked with Erik Lim
