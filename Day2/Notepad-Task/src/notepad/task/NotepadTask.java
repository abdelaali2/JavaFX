package notepad.task;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;


/*
 * @author Ibrahim
 */
public class NotepadTask extends Application {

    boolean saveFlag = true;

    MenuBar bar;
    Menu fileMenu;
    MenuItem newItem;
    MenuItem saveItem;
    MenuItem openItem;
    MenuItem exitItem;
    SeparatorMenuItem sep;

    Menu editMenu;
    MenuItem undoItem;
    MenuItem cutItem;
    MenuItem copyItem;
    MenuItem pasteItem;
    MenuItem deleteItem;
    MenuItem selectallItem;

    Menu helpMenu;
    MenuItem aboutItem;

    TextArea textArea;

    FileChooser fileChooser;

    @Override

    public void init() throws Exception {
        bar = new MenuBar();

        fileMenu = new Menu("File");
        newItem = new MenuItem("New");
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        saveItem = new MenuItem("Save");
        openItem = new MenuItem("Open");
        exitItem = new MenuItem("Exit");
        sep = new SeparatorMenuItem();
        fileMenu.getItems().addAll(newItem, saveItem, openItem, exitItem);
        fileMenu.getItems().add(4, sep);

        editMenu = new Menu("Edit");
        undoItem = new MenuItem("Undo");
        cutItem = new MenuItem("Cut");
        copyItem = new MenuItem("Copy");
        pasteItem = new MenuItem("Paste");
        deleteItem = new MenuItem("Delete");
        selectallItem = new MenuItem("Select All");
        editMenu.getItems().addAll(undoItem, cutItem, copyItem, pasteItem, deleteItem, selectallItem);
        editMenu.getItems().add(1, sep);
        editMenu.getItems().add(5, sep);

        helpMenu = new Menu("Help");
        aboutItem = new MenuItem("About Java Compile");
        helpMenu.getItems().add(aboutItem);

        bar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        textArea = new TextArea();
    }

    @Override
    public void start(Stage primaryStage) {

        openItem.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Open file");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("Java", "*.java"));
            fileChooser.showOpenDialog(primaryStage);
        });
        BorderPane pane = new BorderPane();
        pane.setTop(bar);
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 1000, 720);

        primaryStage.setTitle("My Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
