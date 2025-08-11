package observer.boss;

import observer.domain.Car;

/**
 * boss进房间
 */
public class BossInRomeEvent extends AbstractBossEvent<Car>{

    public BossInRomeEvent(Car source) {
        super(source);
    }

    @Override
    public long timestamp() {
        return super.getTimestamp();
    }

    @Override
    public Car source() {
        return super.getSource();
    }
}
