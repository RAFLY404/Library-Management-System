package ui;

import javafx.scene.control.TextField;

public class SearchBar {

    private final TextField field = new TextField();

    public SearchBar() {
        field.setPromptText("Search by title or author...");
        field.getStyleClass().add("search-field");
    }

    public TextField get() {
        return field;
    }
}
