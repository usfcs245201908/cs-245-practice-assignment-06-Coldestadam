public class ArrayStack<T> implements Stack<T>{
	private T[] a;
	private int top;

	public ArrayStack(){
		a=(T[]) new Object[10];
		top=0;
	}

	public void grow_array(){
		T[] new_arr = (T[]) new Object[a.length*2];
		for(int i=0; i<a.length; i++)
			new_arr[i]= a[i];
		a = new_arr;
	}
	public void push(T item){
		if(top==a.length-1){
			grow_array();
		}
		a[++top]=item;
	}

	/*
	public T pop(){
		try{
			if(empty())
				throw new Exception("You cannot pop any values if the stack is empty");
			return a[top--];
		}
		catch(Exception e){
			throw e;
		}
	}
	*/

	public T pop(){
		if(empty())
			return null;
		return a[top--];
	}

	public T peek(){
		return a[top];
	}

	public boolean empty(){
		if(top==0)
			return true;
		return false;
	}
}