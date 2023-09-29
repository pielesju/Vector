package org.trivial.vector.controller;

import javafx.beans.property.StringProperty;
import javafx.scene.paint.Paint;
import org.trivial.vector.model.Action;

public abstract class Editor {

    public static Action action = Action.DRAW;

    public static Paint color;

    private Editor(){}


}
