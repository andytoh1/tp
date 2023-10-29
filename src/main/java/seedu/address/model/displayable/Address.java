package seedu.address.model.displayable;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.validateArgument;

/**
 * Represents a Displayable's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String MESSAGE_CONSTRAINTS = "Addresses can take any values, and it should not be blank";

    public static final String MESSAGE_RECOMMENDATIONS = MESSAGE_CONSTRAINTS;

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */

    //TODO anyone can think of any stricter constraints on addresses?
    //currently validation and affirmation are the same.
    //Therefore the affirmation will never fail since we only fail affirmation when validation fails,
    //and validation throws an exception.
    //REMOVE THIS if you've resolved this.
    public static final String VALIDATION_REGEX = "[^\\s].*";
    public static final String AFFIRMATION_REGEX = VALIDATION_REGEX;
    public static final String DEFAULT_ADDRESS_STRING = "Placeholder Street, Singapore";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param address A valid address.
     */
    public Address(String address) {
        requireNonNull(address);
        validateArgument(isValidAddress(address), MESSAGE_CONSTRAINTS);
        value = address;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public static boolean isAppropriateAddress(String test) {
        return test.matches(AFFIRMATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Address)) {
            return false;
        }

        Address otherAddress = (Address) other;
        return value.equals(otherAddress.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}