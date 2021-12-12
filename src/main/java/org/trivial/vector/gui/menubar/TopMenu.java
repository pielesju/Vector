/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui.menubar;

import java.util.ArrayList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

/**
 *
 * @author jpieles
 */
public class TopMenu extends MenuBar {

    public TopMenu() {
        this.getMenus().addAll(new FileMenu(),
                new EditMenu(),
                new ViewMenu(),
                new CanvasMenu(),
                new ObjectsMenu(),
                new ToolsMenu(),
                new OptionsMenu(),
                new EffectsMenu(),
                new HelpMenu());
        
        this.setStyle("-fx-background-color: white;");
    }
}
