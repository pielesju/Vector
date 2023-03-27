/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui.optionsbar;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.trivial.vector.Constants;

/**
 *
 * @author jpieles
 */
public class OptionsBar extends VBox {
    
    public static ColorPicker colorPicker;
    
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
        
        gridPane.add(colorPicker,0,4);
        
        TextField t1 = new TextField();
        gridPane.add(t1,1,0);
        TextField t2 = new TextField();
        gridPane.add(t2,1,1);
        TextField t3 = new TextField();
        gridPane.add(t3,1,2);
        TextField t4 = new TextField();
        gridPane.add(t4,1,3);
        
        
        TextArea text = new TextArea();
        
        this.getChildren().addAll(label, gridPane, text);
    }
    
}
