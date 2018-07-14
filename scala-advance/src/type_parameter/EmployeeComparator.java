package type_parameter;

import java.util.Comparator;

/**
 * Comparator 外部比较器
 */
public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getName().equalsIgnoreCase(o2.getName())) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        EmployeeComparator ec = new EmployeeComparator();
        Employee e1 = new Employee("Alice");
        Employee e2 = new Employee("Mary");

        // 通过外部对象进行方法调用
        if(ec.compare(e1, e2) > 0) {
            System.out.println("两者姓名相同");
        } else {
            System.out.println("两者姓名不同");
        }

    }
}
