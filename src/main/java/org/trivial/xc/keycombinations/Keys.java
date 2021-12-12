/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.xc.keycombinations;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 *
 * @author jpieles
 */
public class Keys {

    public static KeyCombination zoomIn = new KeyCodeCombination(KeyCode.PLUS,
            KeyCombination.CONTROL_DOWN);

    public static KeyCombination zoomOut = new KeyCodeCombination(KeyCode.MINUS,
            KeyCombination.CONTROL_DOWN);

}
