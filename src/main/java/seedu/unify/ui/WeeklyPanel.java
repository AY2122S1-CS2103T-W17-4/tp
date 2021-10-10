package seedu.unify.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.unify.commons.core.LogsCenter;
import seedu.unify.model.task.Task;

public class WeeklyPanel extends UiPart<Region> {
    private static final String FXML = "WeeklyPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(WeeklyPanel.class);

    @FXML
    private Label weekLabel;

    @FXML
    private HBox dailyHBox;

    /**
     * Creates a {@code WeeklyPanel} with the given {@code ObservableList}.
     */
    public WeeklyPanel(ObservableList<Task> taskList) {
        super(FXML);
        weekLabel.setText("11/10/2021"); // get date.toString
        StackPane dailyPane = new StackPane(); // replaced with getting pane from daily panel
        // something like DailyPanel.get(index)
        dailyHBox.getChildren().add(dailyPane); // loop 7 times
    }

    private String indexToDay(Integer index) {
        String day;
        switch (index) {
        case 0:
            day = "Monday";
            break;
        case 1:
            day = "Tuesday";
            break;
        case 2:
            day = "Wednesday";
            break;
        case 3:
            day = "Thursday";
            break;
        case 4:
            day = "Friday";
            break;
        case 5:
            day = "Saturday";
            break;
        case 6:
            day = "Sunday";
            break;
        default:
            day = "Unknown";
        }
        return day;
    }
}