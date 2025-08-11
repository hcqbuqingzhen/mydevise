package observer.worker;

import observer.boss.BossEvent;
import observer.domain.Car;

public class BossOutRomeWork implements Work<Car>{
    @Override
    public void doWork(BossEvent<Car> event) {
        System.out.println("BossOutRomeWork: 事件时间戳: " + event.timestamp());
        System.out.println("车牌号: " + event.source().getCarNO()+
                ", 车类型: " + event.source().getCarType());
        System.out.println("BossOutRomeWork: 将车从地库取出,交给老板");
        System.out.println("BossOutRomeWork: 处理工作完成");
    }
}
