package type_parameter;

/**
 * Java Employer 类
 */
public class Employer implements Comparable<Employer> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Employer(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employer o) {
        if(this.getName().equalsIgnoreCase(o.getName())) {
            return 1;
        } else {
            return -1;
        }
    }
}
