package chain.exception;

public class VaildatorExcption extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public VaildatorExcption(String message) {
        super(message);
    }

    public VaildatorExcption(String message, Throwable cause) {
        super(message, cause);
    }

    public VaildatorExcption(Throwable cause) {
        super(cause);
    }
}
