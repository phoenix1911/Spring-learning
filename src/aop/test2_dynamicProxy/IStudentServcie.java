package aop.test2_dynamicProxy;

/**
 * Created by Tjl on 2018/9/5 9:17.
 */
public interface IStudentServcie {
    void save(Dyn_Student student);

    void delete(int id);

    Dyn_Student find(int id);
}
