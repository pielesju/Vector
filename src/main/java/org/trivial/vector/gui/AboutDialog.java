/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui;

import javafx.scene.control.Alert;

/**
 *
 * @author jpieles
 */
public class AboutDialog extends Alert {
    
    public AboutDialog() {
        super(AlertType.INFORMATION);
        this.setTitle("About this application");
        this.setHeaderText("trivial computing - vector");
        this.setContentText("v 0.0.1");
    }
    
    public void showAboutDialog() {
        this.showAndWait();
    }
    
}
