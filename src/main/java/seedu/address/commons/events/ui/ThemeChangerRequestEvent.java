package seedu.address.commons.events.ui;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.events.BaseEvent;

/**
 * Indicate a request to switch theme by the user
 */
public class ThemeChangerRequestEvent extends BaseEvent {

    public final Index index;

    public ThemeChangerRequestEvent(Index index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return this.getClass().toString();
    }
}
