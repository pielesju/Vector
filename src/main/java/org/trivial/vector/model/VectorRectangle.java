package org.trivial.vector.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.trivial.view.optionsbar.OptionsBar;
import org.trivial.xc.utils.TrivialMath;

public class VectorRectangle extends Rectangle implements VectorObject {

    public VectorRectangle(double x, double y, Paint color) {
        super(x, y, 1, 1);
        this.setFill(color);
    }

    public VectorRectangle() {

    }

    @Override
    public VectorObject create(double x, double y, Paint color) {
        return new VectorRectangle(x, y, color);
    }

    @Override
    public void draw(double x, double y, double lastX, double lastY) {
        VectorRectangle rect = this;


        if (x > lastX) {
            rect.setWidth(x - lastX);
        } else {
            rect.setX(x);
            rect.setWidth(TrivialMath.difference(lastX, x));
        }
        if (y > lastY) {
            rect.setHeight(y - lastY);
        } else {
            rect.setY(y);
            rect.setHeight(TrivialMath.difference(lastY, y));
        }
    }
}
