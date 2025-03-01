package seedu.unify.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.unify.testutil.TypicalTasks.getTypicalUniFy;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.unify.commons.core.GuiSettings;
import seedu.unify.model.ReadOnlyUniFy;
import seedu.unify.model.UniFy;
import seedu.unify.model.UserPrefs;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonUniFyStorage uniFyStorage = new JsonUniFyStorage(getTempFilePath("ab"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(uniFyStorage, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    @Test
    public void uniFyReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUniFyStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUniFyStorageTest} class.
         */
        UniFy original = getTypicalUniFy();
        storageManager.saveUniFy(original);
        ReadOnlyUniFy retrieved = storageManager.readUniFy().get();
        assertEquals(original, new UniFy(retrieved));
    }

    @Test
    public void getUniFyFilePath() {
        assertNotNull(storageManager.getUniFyFilePath());
    }

}
