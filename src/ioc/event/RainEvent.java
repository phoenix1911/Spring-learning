package ioc.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Tjl on 2018/9/4 11:13.
 */
//自定义的事件:下雨的事件
public class RainEvent extends ApplicationEvent {

    public RainEvent(Object source) {
        super(source);
    }
}
