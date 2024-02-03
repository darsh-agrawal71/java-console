package lib.input;

import lib.Res;

import java.util.Scanner;
/**
 * Prompts the user for String result.
 */
public class StringInputPrompt implements InputPrompt<String> {

    @Override
    public Result<String> promptUserWithPrompt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(Res.strings.crlf_newline);
        System.out.print(prompt.strip() + Res.strings.space);
        String input = scanner.next();
        return new Result<String>(input);
    }
}
