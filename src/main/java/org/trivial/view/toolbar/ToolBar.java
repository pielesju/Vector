/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.view.toolbar;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.trivial.vector.Constants;
import org.trivial.vector.controller.Editor;
import org.trivial.vector.model.VectorCircle;
import org.trivial.vector.model.VectorLine;
import org.trivial.vector.model.VectorRectangle;
import org.trivial.vector.model.Action;
import org.trivial.view.drawing.VectorCanvas;

/**
 *
 * @author jpieles
 */
public class ToolBar extends VBox {

    public static int currentObject;

    public ToolBar() {
        this.setMinWidth(70);
        this.setMaxWidth(70);
        this.setStyle(String.format("-fx-background-color:%s;", Constants.COLOR_1));

        this.getChildren().addAll(getObjectsBox(), getToolBox());
    }

    private VBox getObjectsBox() {
        VBox box = new VBox();
        box.prefHeightProperty().bind(this.heightProperty().divide(2));

        Button createRectangle = new Button("RECT");
        createRectangle.setMinWidth(68);
        createRectangle.setMaxWidth(68);
        createRectangle.setOnAction(e -> VectorCanvas.setCurrentShape(new VectorRectangle()));
        createRectangle.setStyle(String.format("-fx-background-color:%s;-fx-color:%s;", Constants.COLOR_2,
         Constants.COLOR_1));

        Button createCircle = new Button("CIRC");
        createCircle.setOnAction(e -> VectorCanvas.setCurrentShape(new VectorCircle()));
        createCircle.setMinWidth(68);
        createCircle.setMaxWidth(68);

        Button createLine = new Button("LINE");
        createLine.setOnAction(e -> VectorCanvas.setCurrentShape(new VectorLine()));

        createLine.setMinWidth(68);
        createLine.setMaxWidth(68);

        box.getChildren().addAll(createRectangle, createLine, createCircle);

        return box;
    }

    private VBox getToolBox() {
        VBox box = new VBox();
        
        Button select = new Button("SELECT");
        select.setMinWidth(68);
        select.setMaxWidth(68);
        select.setOnAction(e -> Editor.action = Action.SELECT);

        Button remove = new Button("REMOVE");
        remove.setMinWidth(68);
        remove.setMaxWidth(68);
        remove.setOnAction(e -> Editor.action = Action.REMOVE);

        box.getChildren().addAll(select, remove);
        


        return box;
    }

}
