package lib.input;

import lib.Res;

import java.util.Scanner;

/**
 * Prompts user for integer result.
 */
public class IntegerInputPrompt implements InputPrompt<Integer> {

    @Override
    public Result<Integer> promptUserWithPrompt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt.strip() + Res.strings.space);
        int input;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            return new Result<Integer>(0);
        }
        return new Result<Integer>(input);
    }
}
