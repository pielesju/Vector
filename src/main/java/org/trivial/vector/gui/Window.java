/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui;

import javafx.scene.layout.Pane;
import org.trivial.vector.gui.menubar.TopMenu;
import javafx.scene.layout.BorderPane;
import org.trivial.vector.gui.drawing.VectorCanvas;
import org.trivial.vector.gui.optionsbar.OptionsBar;
import org.trivial.vector.gui.toolbar.ToolBar;

/**
 *
 * @author jpieles
 */
public class Window extends BorderPane {
    
    public Window() {
        this.setTop(new TopMenu());
        this.setLeft(new ToolBar());
        this.setRight(new OptionsBar());
        this.setBottom(new StatusBar());
        this.setCenter(new EditorPane());
    }

}
