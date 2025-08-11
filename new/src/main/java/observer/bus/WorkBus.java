package observer.bus;

import observer.boss.BossEvent;
import observer.worker.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 总线 解耦boss和工人
 */
public class WorkBus {

    private final Map<Class <?extends BossEvent<?>>,List<Work<?>>> eventWorkerMap = new ConcurrentHashMap<>();

    /**
     * 订阅事件
     */
    public <T> void subscribe(Class<? extends BossEvent<T>> eventType, Work<T> work) {
        eventWorkerMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(work);
    }

    /**
     * 发布事件
     */
    public <T> void publish(BossEvent<T> event) {
        List<Work<?>> works = eventWorkerMap.get(event.getClass());
        if (works != null) {
            for (Work<?> work : works) {
                // 使用通配符来处理不同类型的事件
                @SuppressWarnings("unchecked")
                Work<T> typedWork = (Work<T>) work;
                typedWork.doWork(event);
            }
        }
    }
}
