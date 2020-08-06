public class Node<E>{
	private Node<E> next;
	private Node<E> previous;
	private E data;

	private int size;

	public Node(E data){
		next = null;
		previous = null;
		this.data = data;
	}

	public Node<E> next(){
		return next;
	}

	public Node<E> previous(){
		return previous;
	}

	public void setNext(Node<E> next){
		this.next = next;
	}

	public void setPrevious(Node<E> previous){
		this.previous = previous;
	}

	public void setData(E data){
		this.data = data;
	}

	public E get(){
		return data;
	}

	public String toString(){
		return data.toString();
	}
}