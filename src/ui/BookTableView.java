package ui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Book;

public class BookTableView {

    public static TableView<Book> create() {
        TableView<Book> table = new TableView<>();

        TableColumn<Book, String> title = new TableColumn<>("Title");
        title.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getTitle()));

        TableColumn<Book, String> author = new TableColumn<>("Author");
        author.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getAuthor()));

        TableColumn<Book, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getStatus().name()));

        table.getColumns().addAll(title, author, status);
        return table;
    }
}
