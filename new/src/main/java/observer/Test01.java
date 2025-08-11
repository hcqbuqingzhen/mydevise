package observer;

import observer.boss.BossInRomeEvent;
import observer.boss.BossOutRomeEvent;
import observer.bus.WorkBus;
import observer.domain.Car;
import observer.worker.BossInRomeWork;
import observer.worker.BossOutRomeWork;
import observer.worker.Work;

public class Test01 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setCarNO("京A88888");
        car.setCarType("宝马");
        BossInRomeEvent bossInRomeEvent = new BossInRomeEvent(car);
        BossInRomeWork bossInRomeWork = new BossInRomeWork();
        BossOutRomeEvent bossOutRomeEvent = new BossOutRomeEvent(car);
        BossOutRomeWork bossOutRomeWork = new BossOutRomeWork();

        WorkBus workBus = new WorkBus();
        //订阅消息
        workBus.subscribe(bossInRomeEvent.getClass(), bossInRomeWork);
        workBus.subscribe(bossOutRomeEvent.getClass(), bossOutRomeWork);

        //发布消息
        workBus.publish(bossInRomeEvent);
        workBus.publish(bossOutRomeEvent);
    }
}
