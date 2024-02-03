package lib.input;

/**
 * Base interface for an input prompt.
 * @param <T> Generic type of result boxed in {@link Result}.
 */
public interface InputPrompt<T> {
    /**
     * Prompt the user for input.
     * @param prompt The prompt question/field.
     * @return {@link Result} containing {@link T} result.
     */
    Result<T> promptUserWithPrompt(String prompt);

    /**
     * Box containing {@link T} value. <br>
     * Returned from a {@link InputPrompt}
     * @param <T> Type of value stored.
     */
    class Result<T> {
        private final T result;

        public T getResult() {
            return result;
        }

        public Result(T result) {
            this.result = result;
        }
    }
}
