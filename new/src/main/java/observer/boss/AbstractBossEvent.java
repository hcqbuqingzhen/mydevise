package observer.boss;

/**
 * 老板发布事件抽象父类
 */
public abstract class AbstractBossEvent<T> implements BossEvent<T> {
    private final long timestamp;
    private final T source;

    public AbstractBossEvent(T source) {
        this.timestamp = System.currentTimeMillis();
        this.source = source;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public T getSource() {
        return source;
    }
}
