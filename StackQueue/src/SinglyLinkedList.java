public class SinglyLinkedList<E>
{
	private Node<E> head=null;
	private Node<E> tail=null;
	private int size=0;	

	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return size==0;
	}

	public E first()
	{
		if (isEmpty()) return null;
		return head.getElement();
	}

	public E last()
	{
		if (isEmpty()) return null;
		return tail.getElement();
	}

	public void addFirst(E e)
	{
		head=new Node<>(e,head);
		size++;
		if(size==1)
			tail=head;
	}

	public E removeFirst()
	{
		if(isEmpty()) return null;
		E answer=head.getElement();
		head=head.getNext();
		size--;
		if (size==0)
			tail=null;
		return answer;
	}

	public void addLast(E e)
	{
		Node<E> newest=new Node<>(e,null);
		if(isEmpty())
			head=newest;
		else
			tail.setNext(newest);
		tail=newest;
		size++;
	}

	public E removeLast()
	{
		if(isEmpty()) return null;
		else
			if (size==1)
			{
				E answer=tail.getElement();
				head=tail=null;
				return answer;
			}
			else
			{
				E answer=tail.getElement();
				Node<E> t=head;
				while (t.getNext()!=tail)
					t=t.getNext();
				t.setNext(null);
				tail=t;
				size--;
				return answer;
			}
	}

	public void display()
	{
		for (Node<E> t=head;t!=null;t=t.getNext())
			System.out.println(t.getElement());
	}	
}