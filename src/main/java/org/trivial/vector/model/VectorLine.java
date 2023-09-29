package org.trivial.vector.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class VectorLine extends Line implements VectorObject {

    public VectorLine() {

    }

    public VectorLine(double x, double y, Paint color) {
        super();
        this.setStartX(x);
        this.setStartY(y);
        this.setEndX(x);
        this.setEndY(y);
        this.setStroke(color);
    }

    @Override
    public VectorObject create(double x, double y, Paint color) {
        return new VectorLine(x, y, color);
    }

    @Override
    public void draw(double x, double y, double lastX, double lastY) {
        VectorLine line = this;
        line.setEndX(x);
        line.setEndY(y);
    }
}
