/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import org.trivial.vector.gui.drawing.VectorCanvas;
import org.trivial.xc.keycombinations.Keys;

/**
 *
 * @author jpieles
 */
public class EditorPane extends ScrollPane {

    StackPane holder = new StackPane();

    Group zoomGroup;
    Group contentGroup;
    Scale scaleTransform;

    public EditorPane() {
        contentGroup = new Group();
        zoomGroup = new Group();

        contentGroup.getChildren().add(zoomGroup);
        zoomGroup.getChildren().add(getCanvas());
        this.setContent(contentGroup);
        scaleTransform = new Scale(1, 1, 0, 0);
        zoomGroup.getTransforms().add(scaleTransform);

        keepCentered();

        checkForZoom();

        setEditorOptions();
    }

    private void checkForZoom() {
        this.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            if (Keys.zoomIn.match(e)) {
                zoomIn();
            } else if (Keys.zoomOut.match(e)) {
                zoomOut();
            }
            e.consume();
        });
    }

    private void keepCentered() {
        contentGroup.translateXProperty().bind(this.widthProperty().divide(2).subtract(holder.widthProperty().multiply(holder.scaleXProperty()).divide(2)));
        contentGroup.translateYProperty().bind(this.heightProperty().divide(2).subtract(holder.heightProperty().multiply(holder.scaleYProperty()).divide(2)));
    }

    private void setEditorOptions() {
        this.setStyle("-fx-background-color: transparent");
        this.setStyle("-fx-focus-color: transparent;-fx-faint-focus-color:transparent;");
        this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    }

    private void zoomIn() {
        holder.setScaleX(holder.getScaleX() + 0.1);
        holder.setScaleY(holder.getScaleX() + 0.1);
    }

    private void zoomOut() {
        holder.setScaleX(holder.getScaleX() - 0.1);
        holder.setScaleY(holder.getScaleX() - 0.1);
    }

    private StackPane getCanvas() {
        holder.getChildren().add(new VectorCanvas());
        holder.setStyle("-fx-background-color: white;");
        holder.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return holder;
    }

}
