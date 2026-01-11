package ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BookForm {

    public TextField title = new TextField();
    public TextField author = new TextField();

    public HBox get() {
        title.setPromptText("Book Title");
        author.setPromptText("Author");

        title.getStyleClass().add("input-field");
        author.getStyleClass().add("input-field");

        return new HBox(10, title, author);
    }

    public void clear() {
        title.clear();
        author.clear();
    }
}
