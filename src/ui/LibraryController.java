package ui;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Book;
import service.BookService;

public class LibraryController {

    private final BookService service = new BookService();
    private final TableView<Book> table = BookTableView.create();
    private final BookForm form = new BookForm();
    private final SearchBar searchBar = new SearchBar();

    public Pane getView() {
        refresh(service.getBooks());

        Button add = new Button("Add");
        Button del = new Button("Delete");
        Button toggle = new Button("Borrow / Return");

        add.getStyleClass().add("primary-btn");
        del.getStyleClass().add("danger-btn");
        toggle.getStyleClass().add("secondary-btn");

        add.setOnAction(e -> {
            service.addBook(form.title.getText(), form.author.getText());
            form.clear();
            refresh(service.getBooks());
        });

        del.setOnAction(e -> {
            Book b = table.getSelectionModel().getSelectedItem();
            if (b != null) service.removeBook(b);
            refresh(service.getBooks());
        });

        toggle.setOnAction(e -> {
            Book b = table.getSelectionModel().getSelectedItem();
            if (b != null) service.toggle(b);
            refresh(service.getBooks());
        });

        searchBar.get().textProperty().addListener((obs, oldVal, newVal) -> {
            refresh(service.searchBooks(newVal));
        });

        VBox rightButtons = new VBox(12, add, toggle, del);
        rightButtons.getStyleClass().add("side-panel");

        VBox topBox = new VBox(8, searchBar.get(), form.get());
        topBox.getStyleClass().add("top-panel");

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(table);
        root.setRight(rightButtons);

        LayoutUtil.pad(root);
        return root;
    }

    private void refresh(java.util.List<Book> list) {
        table.setItems(FXCollections.observableArrayList(list));
    }
}
