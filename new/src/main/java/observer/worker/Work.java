package observer.worker;

import observer.boss.BossEvent;

public interface Work<T> {
    void doWork(BossEvent<T> event);
}
