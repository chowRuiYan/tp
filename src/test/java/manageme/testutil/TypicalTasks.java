package manageme.testutil;

import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_DESCRIPTION_A;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_DESCRIPTION_B;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_END_A;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_END_B;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_MODULE_A;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_MODULE_B;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_NAME_A;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_NAME_B;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_START_A;
import static manageme.logic.commands.task.TaskCommandTestUtil.VALID_START_B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import manageme.model.ManageMe;
import manageme.model.task.Task;

public class TypicalTasks {
    public static final Task TASK_A = new TaskBuilder().withName("Eat with friends")
            .withDescription("At NUS UTown")
            .withStartDateTime("2021-10-05T11:50")
            .withEndDateTime("2021-10-05T14:00").build();
    public static final Task TASK_B = new TaskBuilder().withName("Work on CS2100 Assignment 2")
            .withDescription("Refer to lectures 7-13")
            .withModule("CS2100")
            .withStartDateTime("2021-10-07T23:59")
            .withEndDateTime("2021-10-14T23:59").build();

    // Manually added - Task's details found in {@code TaskCommandTestUtil}
    public static final Task TASK_A_MANUAL =
            new TaskBuilder().withName(VALID_NAME_A).withDescription(VALID_DESCRIPTION_A)
                    .withModule(VALID_MODULE_A).withStartDateTime(VALID_START_A).withEndDateTime(VALID_END_A).build();
    public static final Task TASK_B_MANUAL =
            new TaskBuilder().withName(VALID_NAME_B).withDescription(VALID_DESCRIPTION_B)
                    .withModule(VALID_MODULE_B).withStartDateTime(VALID_START_B).withEndDateTime(VALID_END_B).build();

    private TypicalTasks() {
    } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical tasks.
     */
    public static ManageMe getTypicalAddressBook() {
        ManageMe ab = new ManageMe();
        for (Task task : getTypicalTasks()) {
            ab.addTask(task);
        }
        return ab;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(TASK_A, TASK_B));
    }
}
