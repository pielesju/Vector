/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.view;

import org.trivial.view.menubar.TopMenu;
import javafx.scene.layout.BorderPane;
import org.trivial.view.optionsbar.OptionsBar;
import org.trivial.view.toolbar.ToolBar;

/**
 *
 * @author jpieles
 */
public class Window extends BorderPane {
    
    public Window() {
        this.setTop(new TopMenu());
        this.setLeft(new ToolBar());
        this.setBottom(new StatusBar());
        this.setRight(new OptionsBar());
        this.setCenter(new EditorPane());
    }

}
