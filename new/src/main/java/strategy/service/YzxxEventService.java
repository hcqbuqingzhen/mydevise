package strategy.service;

import org.springframework.stereotype.Component;
import strategy.annotate.EventType;
import strategy.emnus.EventEnum;

@Component
@EventType(EventEnum.YZXX)
public class YzxxEventService implements EventHandle {
    /**
     * 这里肯定还需要其他的信息,参数不一定是String,可以是其他的对象
     * @param event 事件
     */
    @Override
    public String handle(String event) {
        System.out.println("处理院长信箱事件: " );
        return "处理院长信箱事件: " + event;
    }
}
