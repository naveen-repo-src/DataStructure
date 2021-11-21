package collections;

import java.util.TreeSet;

public class ComparableWithTreeSet {

	static class Student implements Comparable<Student> {
		int id;
		String name;

		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		//sorted by descending order
		public int compareTo(Student o) {
			if (this.id > o.id) {
				return -1;
			} else if (this.id < o.id) {
				return 1;
			} else {
				return 0;
			}
		}

		public String toString() {
			return this.id + " - " + this.name;
		}

	}

	public static void main(String args[]) {
		TreeSet<Student> students = new TreeSet<Student>();
		students.add(new Student(2, "Ram"));
		students.add(new Student(3, "Peter"));
		students.add(new Student(1, "John"));

		for (Student student : students) {
			System.out.println(student);
		}
	}
}
