package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ibrahim
 */
public class JavaFXApplication1 extends Application {

    Text mainText;
    Reflection ref;
    Rectangle rect;
    StackPane root;

    @Override
    public void init() throws Exception {
        super.init();
        mainText = new Text("Ibrahim Badr");
        ref = new Reflection();
        ref.setFraction(0.746f);
        mainText.setEffect(ref);
        mainText.setId("mainText");

        Rectangle rect = new Rectangle(0, 0, 500, 400);
        rect.setId("rect");
        
        root = new StackPane();
        root.getChildren().add(rect);
        root.getChildren().add(mainText);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("JavaFXApplication1Style.css").toExternalForm());

        primaryStage.setTitle("Task 1 - Ibrahim Badr");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

}
