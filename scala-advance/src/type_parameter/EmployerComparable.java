package type_parameter;

/**
 * Comparable 内部比较器
 */
public class EmployerComparable {
    public static void main(String[] args) {
        Employer e1 = new Employer("Alice");
        Employer e2 = new Employer("Mary");

        if(e1.compareTo(e2) > 0 ) {
            System.out.println("两者姓名相同");
        } else {
            System.out.println("两者姓名不同");
        }
    }
}
