/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui.menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 *
 * @author jpieles
 */
public class FileMenu extends Menu {
    
    public FileMenu() {
        this.setText("File");
        
        MenuItem newFile = new MenuItem("new");
        MenuItem openFile = new MenuItem("open");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem save = new MenuItem("save");
        MenuItem saveAs = new MenuItem("save as");
        SeparatorMenuItem separator2 = new SeparatorMenuItem();
        MenuItem print = new MenuItem("print");
        
        this.getItems().addAll(newFile, openFile, separator, save, saveAs, separator2, print);
    }
 
}
