public class Task
{
	/**
	 * Description of the task
	 * */
	private String description;

	/**
	 * next Task to be done
	 * */
	private Task next;

	/**
	 * Importance of task
	 * */
	private int priority;

	/**
	 * Construct task 
	 *
	 * @param description is description of this task
	 * */
	public Task(String  description) {
		this.description = description;
	}

	/**
	 * Construct task with priority
	 *
	 * @param description is description of this task
	 * @param priority is the importance of this task
	 * */
	public Task(String description, int priority) {
		this.description = description;
		this.priority = priority;
	}

	/**
	 * Get description of this task
	 *
	 * @return description as String
	 * */
	public String getDescription() {
		return description;
	}

	/**
	 * Set next task of this task
	 *
	 * @param next is next task
	 * */
	public void setNext(Task next) {
		this.next = next;
	}

	/**
	 * Get next task of this task
	 *
	 * @return next task as Task
	 * */
	public Task getNext() {
		return next;
	}

	/**
	 * Get importance of this task
	 *
	 * @return priority of this task in int
	 * */
	public int getPriority() {
		return priority;
	}
}
