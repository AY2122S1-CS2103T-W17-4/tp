package seedu.unify.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.unify.model.tag.Tag;
import seedu.unify.model.task.Date;
import seedu.unify.model.task.Email;
import seedu.unify.model.task.Name;
import seedu.unify.model.task.Phone;
import seedu.unify.model.task.Task;
import seedu.unify.model.util.SampleDataUtil;

/**
 * A utility class to help with building Task objects.
 */
public class TaskBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_DATE = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Email email;
    private Date date;
    private Set<Tag> tags;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        date = new Date(DEFAULT_DATE);
        tags = new HashSet<>();
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(Task taskToCopy) {
        name = taskToCopy.getName();
        phone = taskToCopy.getPhone();
        email = taskToCopy.getEmail();
        date = taskToCopy.getDate();
        tags = new HashSet<>(taskToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Task} that we are building.
     */
    public TaskBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Task} that we are building.
     */
    public TaskBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Task} that we are building.
     */
    public TaskBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Task} that we are building.
     */
    public TaskBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Task} that we are building.
     */
    public TaskBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Task build() {
        return new Task(name, phone, email, date, tags);
    }
}