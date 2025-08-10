package strategy.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import strategy.annotate.EventType;
import strategy.emnus.EventEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分发event
 */
@Component
public class EventDispatch {

    private Map<EventEnum, EventHandle> eventHandleMap;

    /**
     * 构造器注入
     * @param eventHandleList
     */
    public EventDispatch(List<EventHandle> eventHandleList) {
        this.eventHandleMap =
                eventHandleList.stream()
                        .filter( x -> x.getClass().isAnnotationPresent(EventType.class))
                        .collect(Collectors.toMap(this::getEventType, Function.identity()));
    }

    /**
     * 根据事件类型获取对应的事件处理类
     * @param eventType
     * @return
     */
    public EventHandle getEventHandle(String eventType) {
        if (eventHandleMap == null) {
            return null;
        }
        return eventHandleMap.get(EventEnum.fromString(eventType));
    }

    private EventEnum getEventType(EventHandle eventHandle) {
        EventType annotation = eventHandle.getClass().getAnnotation(EventType.class);
        return annotation.value();
    }


}
