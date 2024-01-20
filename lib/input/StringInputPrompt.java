package lib.input;

import java.util.Scanner;

public class StringInputPrompt implements InputPrompt<String> {

    @Override
    public PromptResult<String> promptUserWithPrompt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\r?\n");
        System.out.print(prompt.strip() + " ");
        String input = scanner.next();
        PromptResult<String> result = new PromptResult<String>(input);
        return result;
    }
}
