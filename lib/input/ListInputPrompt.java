package lib.input;

public class ListInputPrompt implements InputPrompt<Integer> {
    public ListInputPrompt.Result promptUserWithPrompt(String prompt) {
        IntegerInputPrompt integerInputPrompt = new IntegerInputPrompt();
        int result = integerInputPrompt.promptUserWithPrompt(prompt).getResult();
        return new ListInputPrompt.Result(result);
    }

    /** Like a regular {@link lib.input.InputPrompt.Result}, but contains a helper method to convert the result to enum type*/
    public static class Result extends InputPrompt.Result<Integer> {
        public Result(Integer result) {
            super(result);
        }

        /**
         * Converts the result stored to the specified Enum class.
         * @param enumType The class type of the Enum. Obtained with {@code YourEnum.class}.
         * @return The enum value.
         * @param <T> The enum class.
         */
        public <T extends Enum<T>> T convertResultToEnum(Class<T> enumType) {
            T[] values = enumType.getEnumConstants();
            if (this.getResult() <= 0) {
                return values[0];
            } else {
                final int index = (this.getResult() - 1) % values.length;
                return values[index];
            }
        }
    }
}
