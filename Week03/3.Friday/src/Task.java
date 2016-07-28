import java.security.InvalidParameterException;

public class Task implements Comparable<Task> {

	public enum TaskPriority {
		MINIMUM, NORMAL, MAXIMUM
	}

	private String taskName;
	private int duration; // in hours
	private TaskPriority priority; // min, normal, max

	public Task(String name, int duration) {

		if (duration < 0)
			throw new InvalidParameterException("Duration can't be a negative number!");

		this.taskName = name;
		this.duration = duration;
		this.priority = TaskPriority.NORMAL;
	}

	public Task(String name, int duration, TaskPriority priority) {

		if (duration < 0)
			throw new InvalidParameterException("Duration can't be a negative number!");

		this.taskName = name;
		this.duration = duration;
		this.priority = priority;
	}

	public String getName() {
		return taskName;
	}

	public int getDuration() {
		return duration;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	@Override // Because of PriorityQueue's nature of adding the values in
				// ascending order,
				// we'll define compareTo in reverse so that PriorityQueue adds
				// the tasks ordered by priority
	public int compareTo(Task o) {
		if (o.priority == this.priority) {
			return 0;
		} else if (o.priority == TaskPriority.MINIMUM) {
			return -1;
		} else if (o.priority == TaskPriority.NORMAL) {
			if (this.priority == TaskPriority.MINIMUM) {
				return 1;
			} else { // this.priority == TaskPriority.MAXIMUM
				return -1;
			}
		} else { // o.priority == TaskPriority.MAXIMUM
			return 1;
		}
	}

}
