public class ArrayQueue<T> implements Queue<T>{
	private T[] a;
	private int head;
	private int tail;
	private int size;
	
	public ArrayQueue(){
		size=10;
		a = (T[]) new Object[size];
		head=0;
		tail=0;
	}
	
	//This is a Normal Queue

	/*
	public void grow_array(){
		T[] new_arr = (T[]) new Object[a.length*2];
		for(int i=0; i<a.length; i++)
			new_arr[i]= a[i];
		a = new_arr;
		size*=2;
	}

	public T dequeue(){
		if(empty())
			return null;
		else
			return a[head++];
	}

	public void enqueue(T item){
		if(tail==size){
			grow_array();
			a[tail++] = item;
		}

		else{
			a[tail++] = item;
		}
	}

	public boolean empty(){
		if(head==tail)
			return true;
		else
			return false;
	}
	*/

	//Circular Queue
	public T dequeue(){
		if(empty())
			return null;
		else{
			tail=tail%size;
			return a[head++];
		}
	}

	public void enqueue(T item){
		if(head>tail){
			a[tail++]=item;
			if(tail==head){//Checks if the circular array is full
				grow_array();
				tail++;
			}
		}

		else{
			if(tail==size){//Checks if the array is full
				grow_array();
				a[tail++] = item;
			}

			else{
				a[tail++] = item;
			}
		}
	}

	public void grow_array(){
		if(tail==size){
			T[] new_arr = (T[]) new Object[a.length*2];
			for(int i=0; i<a.length; i++)
				new_arr[i]= a[i];
			a = new_arr;
			size*=2;
		}
		else if(tail==head){
			T[] new_arr = (T[]) new Object[a.length*2];
			for(int i=0; i<a.length-head; i++)
				new_arr[i]=a[i+head];
			for(int i=0; i<tail; i++)
				new_arr[a.length-head+i] = a[i];
		}
	}

	public boolean empty(){
		if(head==tail)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		String first = "first";
		queue.enqueue(first);
		System.out.println(queue.empty());
		for(int i=0; i<11; i++)
			queue.enqueue(first);
	}
}