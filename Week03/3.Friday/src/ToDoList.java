import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList {

	Queue<Task> tasks;
	int hoursAvailable;

	public ToDoList(int hoursAvailable) {

		tasks = new PriorityQueue<>();
		this.hoursAvailable = hoursAvailable;
	}

	public void add(Task task) {
		tasks.add(task);
	}

	public void markFinished(Task task) {
		tasks.remove(task);
	}

	public void markCancelled(Task task) {
		tasks.remove(task);
	}

	public Task getTop() {

		if (tasks.size() != 0) {
			Task top = tasks.peek();
			return new Task(top.getName(), top.getDuration(), top.getPriority());
		} else {
			return null;
		}

	}

	public int getTimeNeeded() {
		int total = 0;

		Iterator<Task> iter = tasks.iterator();
		while (iter.hasNext()) {
			total += iter.next().getDuration();
		}

		return total;
	}

	public int getRemainingTime() {
		return this.hoursAvailable - this.getTimeNeeded();
	}

	public boolean canFinish() {
		return this.getRemainingTime() >= 0;
	}

}
