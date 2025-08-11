package observer.boss;

import observer.domain.Car;

public class BossOutRomeEvent extends AbstractBossEvent<Car>{
    public BossOutRomeEvent(Car source) {
        super(source);
    }

    @Override
    public long timestamp() {
        return getTimestamp();
    }

    @Override
    public Car source() {
        return getSource();
    }
}
