package ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by Tjl on 2018/9/4 8:54.
 * Aware :知道的
 */
public class Life_User implements BeanNameAware , BeanFactoryAware {
    private int id;
    private String name;
    private String beanName;

    @Override
    public String toString() {
        return "Life_User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    public String getBeanName() {
        return beanName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("in User setId()"+id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("in User setName()"+name);
        this.name = name;
    }

    public Life_User(int id, String name) {
        System.out.println("User两参构造器");
        this.id = id;
        this.name = name;
    }

    public Life_User() {
        System.out.println("Uesr无参构造器");
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("当前user对象已经可以知道自己的beanName了"+beanName);
        this.beanName  = beanName;

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("当前user对象被创建的时候,被传入了容器的引用"+beanFactory);
    }
    //添加初始化方法
    public void init() {
        System.out.println("in Life_User() ,init-method指明的init()执行");
    }
    //添加销毁方法
    public void destroy() {
        System.out.println("destroy-method指明的destory()被执行");
    }
}
