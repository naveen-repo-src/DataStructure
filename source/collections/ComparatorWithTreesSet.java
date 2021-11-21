package collections;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorWithTreesSet {

	static class Student {
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

		public String toString() {
			return this.id + " - " + this.name;
		}

	}

	static class CustomComparator implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			if (s1.id > s2.id) {
				return -1;
			} else if (s1.id < s2.id) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String args[]) {
		TreeSet<Student> students = new TreeSet<Student>(new CustomComparator());
		students.add(new Student(2, "Ram"));
		students.add(new Student(3, "Peter"));
		students.add(new Student(1, "John"));

		for (Student student : students) {
			System.out.println(student);
		}
	}

}
