package seedu.address.logic.commands;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.events.ui.ThemeChangerRequestEvent;
import seedu.address.logic.commands.exceptions.CommandException;

/**
 * Switch the theme of the address book
 */
public class ThemeChangerCommand extends Command {

    public static final String COMMAND_WORD = "/theme";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Switch to selected theme\n"
            + "1. Dark;   2. Luminous\n"
            + "Parameters: INDEX (must be 1 or 2)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_THEME_SUCCESS = "Theme updated: %1$s";

    private final Index index;

    public ThemeChangerCommand(Index index) {
        this.index = index;
    }

    @Override
    public CommandResult execute() throws CommandException {
        String[] themeArr = {"Dark", "Light", "Ugly"};
        if (index.getZeroBased() >= themeArr.length || index.getZeroBased() < 0) {
            throw new CommandException(Messages.MESSAGE_INVALID_THEME_NUMBER);
        }

        EventsCenter.getInstance().post(new ThemeChangerRequestEvent(index));
        return new CommandResult(String.format(MESSAGE_THEME_SUCCESS, themeArr[index.getZeroBased()]));
    }


    @Override
    public boolean equals(Object other) {
        return other == this //shortcut if same object
                || (other instanceof ThemeChangerCommand
                && this.index.equals(((ThemeChangerCommand) other).index));
    }
}
