/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.view.optionsbar;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import org.trivial.vector.Constants;
import org.trivial.vector.controller.Editor;
import org.trivial.view.drawing.VectorCanvas;

/**
 *
 * @author jpieles
 */
public class OptionsBar extends VBox {

    public OptionsBar() {
        this.setMinWidth(200);
        this.setMaxWidth(200);
        this.setStyle(String.format("-fx-background-color:%s;", Constants.COLOR_1));

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setMinWidth(198);
        colorPicker.setMaxWidth(198);
        colorPicker.setOnAction(e -> Editor.color = colorPicker.getValue());

        this.getChildren().addAll(colorPicker);
    }
    
}
