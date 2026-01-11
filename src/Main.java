import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.LibraryController;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        LibraryController controller = new LibraryController();
        Scene scene = new Scene(controller.getView(), 900, 500);
        scene.getStylesheets().add(
                getClass().getResource("style.css").toExternalForm()
        );

        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
