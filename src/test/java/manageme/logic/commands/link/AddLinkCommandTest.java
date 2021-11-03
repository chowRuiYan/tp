package manageme.logic.commands.link;

import static java.util.Objects.requireNonNull;
import static manageme.testutil.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import manageme.commons.core.GuiSettings;
import manageme.commons.core.index.Index;
import manageme.logic.commands.CommandResult;
import manageme.logic.commands.exceptions.CommandException;
import manageme.model.ManageMe;
import manageme.model.Model;
import manageme.model.ReadOnlyManageMe;
import manageme.model.ReadOnlyUserPrefs;
import manageme.model.link.Link;
import manageme.model.link.LinkModule;
import manageme.model.module.Module;
import manageme.model.task.Task;
import manageme.testutil.LinkBuilder;

public class AddLinkCommandTest {

    @Test
    public void constructor_nullLink_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddLinkCommand(null));
    }

    @Test
    public void execute_linkAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingLinkAdded modelStub = new ModelStubAcceptingLinkAdded();
        Link validLink = new LinkBuilder().build();

        CommandResult commandResult = new AddLinkCommand(validLink).execute(modelStub);

        assertEquals(String.format(AddLinkCommand.MESSAGE_SUCCESS, validLink), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validLink), modelStub.linksAdded);
    }

    @Test
    public void execute_duplicateLink_throwsCommandException() {
        Link validLink = new LinkBuilder().build();
        AddLinkCommand addCommand = new AddLinkCommand(validLink);
        ModelStub modelStub = new ModelStubWithLink(validLink);

        assertThrows(CommandException.class,
                AddLinkCommand.MESSAGE_DUPLICATE_LINK, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Link cs2100 = new LinkBuilder().withName("CS2100").build();
        Link cs2103 = new LinkBuilder().withName("CS2103").build();
        AddLinkCommand addCs2100Command = new AddLinkCommand(cs2100);
        AddLinkCommand addCs2103Command = new AddLinkCommand(cs2103);

        // same object -> returns true
        assertTrue(addCs2100Command.equals(addCs2100Command));

        // same values -> returns true
        AddLinkCommand addCs2100CommandCopy = new AddLinkCommand(cs2100);
        assertTrue(addCs2100Command.equals(addCs2100CommandCopy));

        // different types -> returns false
        assertFalse(addCs2100Command.equals(1));

        // null -> returns false
        assertFalse(addCs2100Command.equals(null));

        // different link -> returns false
        assertFalse(addCs2100Command.equals(addCs2103Command));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getManageMeFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setManageMeFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addLink(Link link) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setManageMe(ReadOnlyManageMe newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyManageMe getManageMe() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasLink(Link link) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteLink(Link target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLink(Link target, Link editedLink) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void openLink(Link target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Link deleteModLink(LinkModule linkModule, Index index) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Link> getFilteredLinkList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredLinkList(Predicate<Link> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteModule(Module target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setModule(Module target, Module editedModule) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Module> getFilteredModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredModuleList(Predicate<Module> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<Module> getReadModule() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setReadModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTask(Task target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTask(Task target, Task editedTask) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getUnfilteredTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Link> getUnfilteredLinkList() {
            throw new AssertionError("This method should not be called.");
        }


        @Override
        public void updateFilteredTaskList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single link.
     */
    private class ModelStubWithLink extends ModelStub {
        private final Link link;

        ModelStubWithLink(Link link) {
            requireNonNull(link);
            this.link = link;
        }

        @Override
        public boolean hasLink(Link link) {
            requireNonNull(link);
            return this.link.isSameLink(link);
        }
    }

    /**
     * A Model stub that always accept the link being added.
     */
    private class ModelStubAcceptingLinkAdded extends ModelStub {
        final ArrayList<Link> linksAdded = new ArrayList<>();

        @Override
        public boolean hasLink(Link link) {
            requireNonNull(link);
            return linksAdded.stream().anyMatch(link::isSameLink);
        }

        @Override
        public void addLink(Link link) {
            requireNonNull(link);
            linksAdded.add(link);
        }

        @Override
        public boolean hasModule(Module module) {
            requireNonNull(module);
            return true;
        }

        @Override
        public ReadOnlyManageMe getManageMe() {
            return new ManageMe();
        }
    }

}
