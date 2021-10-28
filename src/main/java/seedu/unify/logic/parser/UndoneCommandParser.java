package seedu.unify.logic.parser;

import static seedu.unify.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.unify.commons.core.index.Index;
import seedu.unify.logic.commands.UndoneCommand;
import seedu.unify.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new UndoneCommand object
 */
public class UndoneCommandParser implements Parser<UndoneCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the Undone Command
     * and returns a UndoneCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UndoneCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new UndoneCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UndoneCommand.MESSAGE_USAGE), pe);
        }
    }
}
