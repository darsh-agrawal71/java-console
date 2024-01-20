package lib.input;

/**
 * Box containing {@link T} value. <br>
 * Returned from a {@link InputPrompt}
 * @param <T> Type of value stored.
 */
public class PromptResult<T> {
    private final T result;

    public T getResult() {
        return result;
    }

    public PromptResult(T result) {
        this.result = result;
    }
}