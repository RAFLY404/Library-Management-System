package ui;

import javafx.scene.control.Alert;

public class AlertUtil {
    public static void error(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(msg);
        a.show();
    }
}
