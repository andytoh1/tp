package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HOUSE_INFO;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIORITY;

import java.util.Comparator;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.displayable.buyer.Buyer;

/**
 * Represents a command that sorts the buyer list using a comparator.
 */
public class SortBuyerCommand extends Command {

    public static final String COMMAND_WORD = "sort-b";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the buyers in RTPM. "
            + "Parameters: Choose one of "
            + "[" + PREFIX_NAME + "] "
            + "[" + PREFIX_ADDRESS + "] "
            + "[" + PREFIX_HOUSE_INFO + "] "
            + "[" + PREFIX_PRIORITY + "] "
            + "a/d (for ASC/DESC)\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_PRIORITY + "d";

    public static final String MESSAGE_SUCCESS = "Buyer list sorted";

    private final Comparator<Buyer> comparator;

    /**
     * Constructs a SortBuyerCommand based on the comparator to be used.
     * @param comparator the comparator which will be used to arrange the list.
     */
    public SortBuyerCommand(Comparator<Buyer> comparator) {
        requireNonNull(comparator);
        this.comparator = comparator;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.updateFilteredSortedBuyerList(comparator);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SortBuyerCommand)) {
            return false;
        }

        SortBuyerCommand otherSortBuyerCommand = (SortBuyerCommand) other;
        return comparator.equals(otherSortBuyerCommand.comparator);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("comparator", comparator)
                .toString();
    }
}
