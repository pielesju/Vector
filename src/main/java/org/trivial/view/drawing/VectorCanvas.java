/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.view.drawing;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.trivial.vector.controller.Editor;
import org.trivial.vector.model.Action;
import org.trivial.vector.model.VectorObject;
import org.trivial.vector.model.VectorRectangle;
import org.trivial.view.optionsbar.OptionsBar;

/**
 *
 * @author jpieles
 */
public class VectorCanvas extends Pane {

    public static VectorObject currentShape = new VectorRectangle();
    private static VectorObject selectedShape;


    Double lastX;
    Double lastY;

    public VectorCanvas() {
        setCanvasSettings();
        setCanvasEvents();
    }
    
    public static void setCurrentShape(VectorObject shape) {
        currentShape = shape;
    }

    private void setCanvasSettings() {
        this.setMinWidth(300);
        this.setMinHeight(200);
        this.setMaxWidth(300);
        this.setMaxHeight(200);
        this.setStyle(String.format("-fx-background-color:white;"));
    }

    private void setCanvasEvents() {
        this.setOnMousePressed(e -> createObject(e.getX(), e.getY()));
        this.setOnMouseReleased(e -> drawObject(e.getX(), e.getY()));
        this.setOnMouseDragged(e -> updateShape(e.getX(), e.getY()));
    }

    private void updateShape(double x, double y) {
        if(!this.intersects(x,y,x,y)) {
            return;
        }

        currentShape.draw(x, y, lastX, lastY);
    }

    private void createObject(double x, double y) {
        if(!this.intersects(x, y, x, y)) {
            return;
        }

        lastX = x;
        lastY = y;

        if(Editor.action == Action.DRAW) {
            VectorObject o = currentShape.create(x, y, Editor.color);
            currentShape = o;
            this.getChildren().add((Node) o);
        } else if(Editor.action == Action.SELECT) {
            for(Node n : this.getChildren()) {
                if(n.intersects(x, y, x, y)) {
                    selectedShape = (VectorObject) n;
                }
            }
        } else if(Editor.action == Action.REMOVE) {
            for(Node n : this.getChildren()) {
                if(n.intersects(x, y, x, y)) {
                    this.getChildren().remove(n);
                }
            }
        }









    }

    private void drawObject(double x, double y) {
        if(!this.intersects(x,y,x,y)) {
            return;
        }

        currentShape.draw(x, y, lastX, lastY);
    }






    
}
