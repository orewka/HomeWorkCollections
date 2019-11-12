package collections;

import java.lang.reflect.Array;
import java.util.*;

// Создать список объетов List<Employee>
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int) (Math.random() * 11)], companies[(int) (Math.random() * 7)], 50000 + (int) (Math.random() * 50000), 40 + (int) (Math.random() * 22))); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }

    static class EmployeeNameComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class EmployeeSalaryComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getSalary(),o2.getSalary());
        }
    }

    static class EmployeeAgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(),o2.getAge());
        }
    }

    static class EmployeeCompanyComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getCompany().compareTo(o2.getCompany());
        }
    }

    public static void main(String[] args) {
        List<Employee> task = new ArrayList<>(employeeGenerator(10));
        System.out.println(task.toString());
        Comparator employeeNameComparator = new EmployeeNameComparator();
        Collections.sort(task,employeeNameComparator);
        System.out.println(task);
        Comparator employeeNameSalaryComparator = new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator());
        Collections.sort(task,employeeNameSalaryComparator);
        System.out.println(task);
        Comparator employeeNameSalaryAgeCompanyComparator = new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator().thenComparing(new EmployeeAgeComparator().thenComparing(new EmployeeCompanyComparator())));
        Collections.sort(task,employeeNameSalaryAgeCompanyComparator);
        System.out.println(task);
    }
}


