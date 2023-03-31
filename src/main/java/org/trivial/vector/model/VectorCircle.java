package org.trivial.vector.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.trivial.xc.utils.TrivialMath;

public class VectorCircle extends Circle implements VectorObject {

    public VectorCircle() {

    }

    public VectorCircle(double x, double y, Paint color) {
        super();
        this.setCenterX(x);
        this.setCenterY(y);
        this.setFill(color);
    }

    @Override
    public VectorObject create(double x, double y, Paint color) {
        return new VectorCircle(x, y, color);
    }

    @Override
    public void draw(double x, double y, double lastX, double lastY) {
        double r = TrivialMath.pythagoras(TrivialMath.difference(x, lastX), TrivialMath.difference(y, lastY));
        VectorCircle circle = this;
        circle.setRadius(r);
    }
}
