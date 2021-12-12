/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.trivial.vector.SystemInfo;

/**
 *
 * @author jpieles
 */
public class StatusBar extends HBox {

    public StatusBar() {
        Label versionLabel = new Label(SystemInfo.javaVersion() + " - " + SystemInfo.javafxVersion());
        this.getChildren().add(versionLabel);
        
        Label infoLabel = new Label("Trivial Computing - Vector");
        this.getChildren().add(infoLabel);
          
        setOptions();
    }
    
    private void setOptions() {
        this.setMinHeight(32);
        this.setMaxHeight(32);
        this.setStyle("-fx-background-color:white;");
        this.setPadding(new Insets(0, 200, 0, 50));
    }
    
}
