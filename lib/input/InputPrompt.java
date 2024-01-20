package lib.input;

/**
 * Base interface for an input prompt.
 * @param <T> Generic type of result boxed in {@link PromptResult}.
 */
public interface InputPrompt<T> {
    /**
     * Prompt the user for input.
     * @param prompt The prompt question/field.
     * @return {@link PromptResult} containing {@link T} result.
     */
    PromptResult<T> promptUserWithPrompt(String prompt);
}
