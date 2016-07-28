import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	private String name;
	private List<Integer> grades;

	public Student(String name, List<Integer> grades) {
		this.name = name;

		this.grades = new ArrayList<>();
		this.grades.addAll(grades);
	}

	public String getName() {
		return name;
	}

	public List<Integer> getGrades() {
		List<Integer> copyList = new ArrayList<>();
		copyList.addAll(grades);
		return copyList;
	}

	public double getAverageGrade() {
		double total = 0;
		for (Integer grade : grades) {
			total += grade.doubleValue();
		}

		return total / grades.size();
	}

}

public class StudentProblem {

	public static void sortStudents(List<Student> students) {

		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {

				double diff = o1.getAverageGrade() - o2.getAverageGrade();
				if (diff > 0)
					return 1;
				else if (diff < 0)
					return -1;
				else
					return o1.getName().compareTo(o2.getName());
			}
		});
	}

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		students.add(new Student("Sarah", Arrays.asList(6, 6)));
		students.add(new Student("Pesho", Arrays.asList(6, 5, 5, 4)));
		students.add(new Student("Bob", Arrays.asList(5, 4)));
		students.add(new Student("Josh", Arrays.asList(4, 6, 6)));
		students.add(new Student("Joey", Arrays.asList(6, 6, 6)));

		sortStudents(students);

		for (Student student : students) {
			System.out.println(student.getName() + " - " + student.getAverageGrade());
		}
	}

}
