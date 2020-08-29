//Programmer: Austin Parker Date: Aug 26, 2020
//Assignment: 3x3 Grid - 14.4
//Purpose: Create 3x3 colored grid using JavaFX for GUI

package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));*/
        GridPane root = new GridPane();
        /*offloads the vgap and hgap values from fxml file to main class*/
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        Pane pane = new Pane();
        primaryStage.setTitle("Exercise 14");
        /*sets the default window size*/
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
        /*valuse to display red vertical lines*/
        double divider = 3;
        /*loop makes red vertical line display twice in window*/
        for (int i = 0; i < 2; i++) {
            Line line = new Line();
            line.setStroke(Color.RED);
            line.startXProperty().bind(pane.widthProperty().divide(divider));
            line.startYProperty().bind(pane.layoutYProperty());
            line.endXProperty().bind(line.startXProperty());
            line.endYProperty().bind(pane.heightProperty());
            pane.getChildren().add(line);
            divider /= 2;

        }
        /*values to display blue horizontal lines*/
        divider = 3;
        /*loop makes the blue horizontal line display twice in window*/
        for (int i = 0; i < 2; i++) {
            Line line = new Line();
            line.setStroke(Color.BLUE);
            line.startXProperty().bind(pane.layoutXProperty());
            line.startYProperty().bind(pane.heightProperty().divide(divider));
            line.endXProperty().bind(pane.widthProperty());
            line.endYProperty().bind(pane.heightProperty().divide(divider));
            pane.getChildren().add(line);
            divider /= 2;

        }
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
