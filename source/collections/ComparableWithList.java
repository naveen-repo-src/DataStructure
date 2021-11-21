package collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import collections.ComparableWithTreeSet.Student;

public class ComparableWithList {

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

		// sorted by descending order
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> students = new LinkedList<Student>();
		students.add(new Student(2, "Ram"));
		students.add(new Student(3, "Peter"));
		students.add(new Student(1, "John"));
		Collections.sort(students);
		for (Student student : students) {
			System.out.println(student);
		}
	
	}

}
