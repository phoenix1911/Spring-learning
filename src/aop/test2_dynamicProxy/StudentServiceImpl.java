package aop.test2_dynamicProxy;

/**
 * Created by Tjl on 2018/9/5 9:19.
 */
//委托类 :只想专注于本身的业务处理
public class StudentServiceImpl implements IStudentServcie{

    @Override
    public void save(Dyn_Student student) {
        System.out.println("save()真正执行");

    }

    @Override
    public void delete(int id) {
        System.out.println("delete()真正执行");

    }

    @Override
    public Dyn_Student find(int id) {
        System.out.println("find())真正执行");
        return new Dyn_Student(1,"zs");
    }
}
