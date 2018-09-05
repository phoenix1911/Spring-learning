package ioc.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by Tjl on 2018/9/4 11:15.
 */
public class RainEventListener3 implements ApplicationListener<RainEvent> {

    //监听器 如果配置进入到spring ,只要容器发布下雨事件,就会执行onApplicationEvent方法
    @Override
    public void onApplicationEvent(RainEvent rainEvent) {
        System.out.println("RainEventListener3:" + rainEvent.getSource());
        System.out.println("监听器3说:下雨了");
    }
}
