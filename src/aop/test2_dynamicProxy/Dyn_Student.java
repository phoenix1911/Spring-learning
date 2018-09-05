package aop.test2_dynamicProxy;

/**
 * Created by Tjl on 2018/9/5 9:16.
 */
public class Dyn_Student {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Dyn_Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dyn_Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dyn_Student() {
    }
}
