public class DLList<E>{
	private Node<E> dummy;
	private Node<E> current;
	private int size;

	public DLList(){
		dummy = new Node<E>(null);
		dummy.setPrevious(dummy);
		dummy.setNext(dummy);
		size = 0;
	}

	public void add(E e){
		Node<E> newNode = new Node<E>(e);

		if(size == 0){
			dummy.setNext(newNode);
			dummy.setPrevious(newNode);
			newNode.setNext(dummy);
			newNode.setPrevious(dummy);
		} else {
			newNode.setNext(dummy);
			newNode.setPrevious(dummy.previous());
			dummy.previous().setNext(newNode);
			dummy.setPrevious(newNode);
		}

		size += 1;
		
	}

	public Node<E> get(int loc){
		int counter = 0;

		current = dummy.next();

		while(current != null){
			if(counter == loc){
				return current;
			}
			counter += 1;
			current = current.next();
		}

		return null;
	}

	public void set(int loc, E e){
    	int counter = 0;
    	current = dummy.next();
    
    	while(counter < size){
      		if(counter == loc){
        		current.setData(e);
        		break;
      		}
      		current = current.next();
      		counter += 1;
    	}
  	}

	public int indexOf(E e){
		int counter = 0;

		current = dummy.next();

		while(current != null){
			if(current.get().equals(e)){
				return counter;
			}
			counter += 1;
			current = current.next();
		}

		return -1;
	}

	public void remove(int index) {
    	Node<E> temp = get(index);
    
    	temp.next().setPrevious(temp.previous());
   		temp.previous().setNext(temp.next());
    
    	size--;
  	}

	public void remove(E data) {
    	Node<E> current = dummy.next();

    	while (current.get() != null) {
      		if (current.next().get().equals(data)) {
        		current.setNext(current.next().next());
        		current.next().next().setPrevious(current);
        		size--;
        		break;
      		}
      
      		current = current.next();
    	}
  	}

	public int size(){
		return size;
	}
	
	public String toString(){
		String str = "";

		for(int i = 0; i < size; i++){
			str += get(i).toString();
			str += ",";
		}

		return str;
	}

	public E rand(){
		int rand = (int)(Math.random()*size);

		Node<E> randomNode = this.get(rand);
		remove(rand);

		return randomNode.get();
	}

	public void clear(){
		dummy = new Node<E>(null);
		dummy.setPrevious(dummy);
		dummy.setNext(dummy);
		size = 0;
	}

	public Node<E> dummy(){
		return dummy;
	}

	public int hashCode(){
		return get(0).get().hashCode();
	}
}