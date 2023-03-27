/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui.optionsbar;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.trivial.vector.Constants;
import org.trivial.vector.gui.drawing.VectorCanvas;

/**
 *
 * @author jpieles
 */
public class OptionsBar extends VBox {
    
    public static ColorPicker colorPicker;

    public static TextArea text;

    public static Spinner t1;
    public static TextField t2;
    public static TextField t3;
    public static TextField t4;
    
    public OptionsBar() {
        this.setMinWidth(200);
        this.setMaxWidth(200);
        this.setStyle(String.format("-fx-background-color:%s;", Constants.COLOR_1));
        
        Label label = new Label("Optionen zu Object");
        
        GridPane gridPane = new GridPane();
        Label l1 = new Label("Test");
        gridPane.add(l1,0,0);
        Label l2 = new Label("Test");
        gridPane.add(l2,0,1);
        Label l3 = new Label("Test");
        gridPane.add(l3,0,2);
        Label l4 = new Label("Test");
        gridPane.add(l4,0,3);
        
        colorPicker = new ColorPicker();

        t1 = new Spinner();
        t1.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 300, 0));
        t1.setEditable(true);
        t1.setOnKeyReleased(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                VectorCanvas.currentShape.setLayoutX(Double.parseDouble(t1.getEditor().getText()));
            }
        });
        gridPane.add(t1,1,0);
        t2 = new TextField();
        gridPane.add(t2,1,1);
        t3 = new TextField();
        gridPane.add(t3,1,2);
        t4 = new TextField();
        gridPane.add(t4,1,3);
        
        
        text = new TextArea();
        
        this.getChildren().addAll(label, gridPane, colorPicker, text);
    }
    
}
