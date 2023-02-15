package notepad.task;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    MenuBar bar;
    Menu fileMenu;
    MenuItem newItem;//
    MenuItem saveItem;
    MenuItem openItem;//
    MenuItem exitItem;
    SeparatorMenuItem sep1;
    SeparatorMenuItem sep2;
    SeparatorMenuItem sep3;

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
        newItem.setAccelerator(KeyCombination.keyCombination("Alt+n"));
        saveItem = new MenuItem("Save");
        saveItem.setAccelerator(KeyCombination.keyCombination("Alt+s"));
        openItem = new MenuItem("Open");
        openItem.setAccelerator(KeyCombination.keyCombination("Alt+o"));
        exitItem = new MenuItem("Exit");
        sep1 = new SeparatorMenuItem();
        fileMenu.getItems().addAll(newItem, saveItem, openItem, exitItem);
        fileMenu.getItems().add(3, sep1);

        editMenu = new Menu("Edit");
        undoItem = new MenuItem("Undo");
        undoItem.setAccelerator(KeyCombination.keyCombination("Alt+Ctrl+z"));
        cutItem = new MenuItem("Cut");
        cutItem.setAccelerator(KeyCombination.keyCombination("Alt+x"));
        copyItem = new MenuItem("Copy");
        copyItem.setAccelerator(KeyCombination.keyCombination("Alt+c"));
        pasteItem = new MenuItem("Paste");
        pasteItem.setAccelerator(KeyCombination.keyCombination("Alt+v"));
        deleteItem = new MenuItem("Delete");
        deleteItem.setAccelerator(KeyCombination.keyCombination("Alt+n"));
        selectallItem = new MenuItem("Select All");
        editMenu.getItems().addAll(undoItem, cutItem, copyItem, pasteItem, deleteItem, selectallItem);
        sep2 = new SeparatorMenuItem();
        sep3 = new SeparatorMenuItem();
        editMenu.getItems().add(1, sep2);
        editMenu.getItems().add(6, sep3);

        helpMenu = new Menu("Help");
        aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem);

        bar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        textArea = new TextArea();
    }

    @Override
    public void start(Stage primaryStage) {

        newItem.setOnAction(e -> {
            textArea.clear();
        });

        saveItem.setOnAction(e -> {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Save file");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("Java", "*.java"));
            fileChooser.showSaveDialog(primaryStage);
        });

        openItem.setOnAction(e -> {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Open file");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("Java", "*.java"));
            fileChooser.showOpenDialog(primaryStage);
        });

        exitItem.setOnAction((ActionEvent event) -> {
            System.exit(0);
            primaryStage.close();
        });

        undoItem.setOnAction((ActionEvent event) -> {
            textArea.undo();
        });

        cutItem.setOnAction((ActionEvent event) -> {
            textArea.cut();
        });

        copyItem.setOnAction((ActionEvent event) -> {
            textArea.copy();
        });

        pasteItem.setOnAction((ActionEvent event) -> {
            textArea.paste();
        });
        deleteItem.setOnAction((ActionEvent event) -> {
            textArea.deletePreviousChar();
        });
        selectallItem.setOnAction((ActionEvent event) -> {
            textArea.selectAll();
        });

        aboutItem.setOnAction(e -> {
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Developed by Ibrahim Badr - ITI IoT Track 2023");
            a.show();
        });

        BorderPane pane = new BorderPane();

        pane.setTop(bar);

        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 1000, 720);

        primaryStage.setTitle(
                "My Notepad");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
