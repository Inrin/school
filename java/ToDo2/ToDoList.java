public class ToDoList
{
	/**
	 * First task to be done
	 **/
	private	Task first;

	/**
	 * Construct to-do list
	 * */
	public ToDoList() {
		first = null;
	}

	/**
	 * remove completed first task from list.
	 * */
	public void deleteTask() {
		if(first != null){
			Task nextTmp = first.getNext();
			first.setNext(null);
			first = nextTmp;
		}
		else {
			System.out.println("No Task available. This Incident will be reported\n");
		}
	}

	/**
	 * Add new task to the list.
	 *
	 * @param description is description of new task
	 * */
	public void enqueue(String description) {
		if(first == null)
			first = new Task(description);
		else
			getLast().setNext(new Task(description));
	}

	/**
	 * Print description of first Task in queue
	 **/
	public void printFirst(){
		System.out.println(first.getDescription());
	}

	/**
	 * Print all descriptions of all tasks in the list. 
	 * */
	public void printAll() {
		Task tmp = first;
		if(first != null) {
			while(tmp != null) {
				System.out.println(tmp.getDescription());
				tmp = tmp.getNext();
			}
		}
		else {
			System.out.println("The ToDoList is blank");
		}
	}

	/**
	 * Get first task description in the list.
	 *
	 * @return is description of first task as String
	 * */
	public String getFirst(){
		if(first != null)
			return first.getDescription();
		else
			return null;
	}

	/**
	 * Get last task in the list.
	 *
	 * @return is last task as Task
	 * */
	private Task getLast() {
		Task last = first;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		return last;
	} 
}
