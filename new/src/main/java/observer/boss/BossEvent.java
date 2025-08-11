package observer.boss;

public interface BossEvent <T>{
    long timestamp();

    T source();
}
