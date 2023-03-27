/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui.toolbar;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.trivial.vector.Constants;
import org.trivial.vector.gui.drawing.VectorCanvas;

/**
 *
 * @author jpieles
 */
public class ToolBar extends VBox {

    public static int currentObject;

    public ToolBar() {
        this.setMinWidth(50);
        this.setMaxWidth(50);
        this.setStyle(String.format("-fx-background-color:%s;", Constants.COLOR_1));

        this.getChildren().addAll(getObjectsBox(), getToolBox());
    }

    private GridPane getObjectsBox() {
        GridPane gridPane = new GridPane();
        gridPane.prefHeightProperty().bind(this.heightProperty().divide(2));

        Button createRectangle = new Button("R");
        createRectangle.setOnAction(e -> VectorCanvas.setCurrentShape(new Rectangle()));
        createRectangle.setStyle(String.format("-fx-background-color:%s;-fx-color:%s;", Constants.COLOR_2,
         Constants.COLOR_1));

        Button createCircle = new Button("C");
        createCircle.setOnAction(e -> VectorCanvas.setCurrentShape(new Circle()));

        Button createLine = new Button("L");
        createLine.setOnAction(e -> VectorCanvas.setCurrentShape(new Line()));

        Button createRoundedRect = new Button("RR");
        createRoundedRect.setOnAction(e -> currentObject = 4);

        Button createEllipse = new Button("E");
        createEllipse.setOnAction(e -> currentObject = 5);

        Button createPolygon = new Button("PG");
        createPolygon.setOnAction(e -> currentObject = 6);

        Button createPolyLine = new Button("PL");
        createPolyLine.setOnAction(e -> currentObject = 7);

        Button createPath = new Button("P");
        createPath.setOnAction(e -> currentObject = 8);

        Button createText = new Button("T");
        createText.setOnAction(e -> currentObject = 9);

        gridPane.add(createRectangle, 0, 0);
        gridPane.add(createRoundedRect, 1, 0);

        gridPane.add(createCircle, 0, 1);
        gridPane.add(createEllipse, 1, 1);

        gridPane.add(createLine, 0, 2);
        gridPane.add(createPolyLine, 1, 2);

        gridPane.add(createPolygon, 0, 3);
        gridPane.add(createPath, 1, 3);

        gridPane.add(createText, 0, 4);

        return gridPane;
    }

    private GridPane getToolBox() {
        GridPane gridPane = new GridPane();
        
        Button selectRect = new Button("");
        Button moveSelectedObjects = new Button("");
        Button lassoSelection = new Button("");
        Button moveSelection = new Button("");
        
        gridPane.add(selectRect, 0, 0);
        gridPane.add(moveSelectedObjects, 1, 0);
        gridPane.add(lassoSelection, 0, 1);
        gridPane.add(moveSelection, 1, 1);

        return gridPane;
    }

}
