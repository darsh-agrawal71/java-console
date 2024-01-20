package lib.input;

import java.util.Scanner;

/**
 * Useful prompt for working with lists as it serves as a prompt for Integers.
 */
public class ListInputPrompt implements InputPrompt<Integer> {
    public PromptResult<Integer> promptUserWithPrompt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt.strip() + " ");
        int input;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            return new PromptResult<Integer>(0);
        }
        return new PromptResult<Integer>(input);
    }
}
