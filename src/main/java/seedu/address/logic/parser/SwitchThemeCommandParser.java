package seedu.address.logic.parser;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.ThemeChangerCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses the given {@code String} of arguments in the context of the ThemeChangerCommand
 * and returns an ThemeChangerCommand object for execution.
 */
public class SwitchThemeCommandParser implements Parser<ThemeChangerCommand> {

    @Override
    public ThemeChangerCommand parse(String userInput) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(userInput);
            return new ThemeChangerCommand(index);
        } catch (IllegalValueException e) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT,
                    ThemeChangerCommand.MESSAGE_USAGE));
        }
    }

}
