package observer.worker;

import observer.boss.BossEvent;
import observer.domain.Car;

public class BossInRomeWork implements Work<Car>{

    @Override
    public void doWork(BossEvent<Car> event) {
        System.out.println("BossInRomeWork: 事件时间戳: " + event.timestamp());
        System.out.println("车牌号: " + event.source().getCarNO()+
                ", 车类型: " + event.source().getCarType());
        System.out.println("BossInRomeWork: 接过车钥匙,将车停好");
        System.out.println("BossInRomeWork: 处理工作完成");
    }
}
