package myprep.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import myprep.model.Employee;
import myprep.model.MyUtility;
import myprep.model.Student1;

public class ComplexListStreamOperations {

	public static void main(String[] args) {
		List<myprep.model.Student1> students = MyUtility.getStudents1();

		//1- Find list of students whose first name starts with alphabet A
		List<String> list = students.stream().filter(s -> s.getFirstName().startsWith("A")).map(Student1::getFirstName)
				.collect(Collectors.toList());
		System.out.println(list);

		//2- Group The Student By Department Names
		Map<String, List<Student1>> map = students.stream().collect(Collectors.groupingBy(Student1::getDepartmantName));
		map.forEach((dept, stuList) -> {
			System.out.println(dept + ":");
			for (Student1 s : stuList) {
				System.out.println(s.getFirstName());
			}
		});

		//3- Find the total count of student using stream
		long count = students.stream().count();
		System.out.println(count);

		//4- Find the max age of student
		Student1 student1 = students.stream().max(Comparator.comparing(Student1::getAge)).get();
		System.out.println(student1.getFirstName() + "  " + student1.getAge());

		//5- Find all departments names
		List<String> list2 = students.stream().map(Student1::getDepartmantName).distinct().collect(Collectors.toList());
		System.out.println(list2);

		//6- Find the count of student in each department
		Map<String, Long> map2 = students.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.counting()));
		map2.forEach((dept, count1) -> {
			System.out.println(dept + "-->" + count1);
		});

		//7- Find the list of students whose age is less than 30
		List<Student1> list3 = students.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList());
		for (Student1 s : list3) {
			System.out.println(s.getFirstName() + "-->" + s.getAge());
		}

		//8- Find the list of students whose rank is in between 50 and 100
		List<Student1> list4 = students.stream().filter(s -> s.getRank() > 50 && s.getRank() < 100)
				.collect(Collectors.toList());
		for (Student1 s : list4) {
			System.out.println(s.getFirstName() + "->" + s.getRank());
		}

		//9- Find the average age of male and female students
		Map<String, Double> map3 = students.stream()
				.collect(Collectors.groupingBy(Student1::getGender, Collectors.averagingInt(Student1::getAge)));
		System.out.println(map3);

		//10- Find the department who is having maximum number of students
		//Created a Map with DeptName and no of students and mapped to TreeMap as it has ability to fetch last entry in the Map so collected to TreeMap
		//Then fetched the last entry(Key, value) pair
		Entry<String, Long> entry = students.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new))
				.entrySet().stream().findFirst().get();
		System.out.println(entry.getKey() + "-->" + entry.getValue());

		Entry<String, Long> entry2 = students.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.counting())).entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oVal, nVal) -> oVal, TreeMap::new))
				.lastEntry();
		System.out.println(entry2.getKey() + "--->" + entry2.getValue());

		//11- Find the Students who stays in Karnataka and sort them by their names
		List<Student1> list5 = students.stream().filter(s -> s.getCity().equalsIgnoreCase("Karnataka"))
				.sorted(Comparator.comparing(Student1::getFirstName)).collect(Collectors.toList());
		for (Student1 s : list5) {
			System.out.println(s.getFirstName() + "-->" + s.getCity());
		}
		//12- Find the average rank in all departments
		Map<String, Double> map4 = students.stream().collect(
				Collectors.groupingBy(Student1::getDepartmantName, Collectors.averagingInt(Student1::getRank)));
		map4.forEach((k, v) -> {
			System.out.println(k + "-->" + v);
		});

		//13- Find the highest rank in each department
		Map<String, Optional<Student1>> map5 = students.stream().collect(Collectors
				.groupingBy(Student1::getDepartmantName, Collectors.maxBy(Comparator.comparing(Student1::getRank))));
		map5.forEach((dept, opt) -> {
			System.out.println(dept + "--+->" + opt.get().getFirstName() + "-+->" + opt.get().getRank());
		});

		//14- Find the list of students and sort them by their rank
		List<Student1> list6 = students.stream().sorted(Comparator.comparing(Student1::getRank))
				.collect(Collectors.toList());
		for (Student1 s : list6) {
			System.out.println(s.getRank() + "--->" + s.getFirstName());
		}

		//15- Find the student who has second rank
		Student1 student12 = students.stream().sorted(Comparator.comparing(Student1::getRank)).skip(1).findFirst()
				.get();
		System.out.println(student12.getFirstName() + "-->" + student12.getRank());

		//16. Find Student's Firstname department wise Map<String, List<String>>
		Map<String, List<String>> map6 = students.stream().collect(Collectors.groupingBy(Student1::getDepartmantName,
				Collectors.mapping(Student1::getFirstName, Collectors.toList())));
		System.out.println(map6);

		//17: Sorting Employees by Name and Age | sorting using two feilds
		Comparator<Student1> c1 = Comparator.comparing(Student1::getFirstName);
		Comparator<Student1> c2 = Comparator.comparing(Student1::getAge);
		List<Student1> list7 = students.stream().sorted(c1.thenComparing(c2)).collect(Collectors.toList());

		//Find all the second highest salaried employees
		List<Employee> employees = MyUtility.getEmployees();
		Double secondHigh = employees.stream().map(Employee::getSal).distinct().sorted(Comparator.reverseOrder())
				.skip(1).findFirst().get();
		List<Employee> list9 = employees.stream().filter(e -> e.getSal().equals(secondHigh))
				.collect(Collectors.toList());
		System.out.println("---------------");
		for (Employee e : list9) {
			System.out.println(e.getName() + "-+->" + e.getSal());
		}
		System.out.println("---------------");
		Map<Double, List<String>> map7 = employees.stream().collect(
				Collectors.groupingBy(Employee::getSal, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(map7);
		Entry<Double, List<String>> entry3 = map7.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldv, newv) -> oldv, LinkedHashMap::new))
				.entrySet().stream().skip(1).findFirst().get();
		System.out.println(entry3);
		System.out.println("---------------");
	}

}
