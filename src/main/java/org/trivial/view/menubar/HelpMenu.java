/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.view.menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.trivial.view.AboutDialog;

/**
 *
 * @author jpieles
 */
public class HelpMenu extends Menu {
    
    public HelpMenu() {
        this.setText("Help");
        
        MenuItem about = new MenuItem("about");
        about.setOnAction(e -> new AboutDialog().showAboutDialog());

        this.getItems().addAll(about);
    }

}
