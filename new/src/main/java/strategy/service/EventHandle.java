package strategy.service;

public interface EventHandle {
    /**
     * 事件处理
     *
     * @param eventType 事件
     */
    String handle(String eventType);
}
