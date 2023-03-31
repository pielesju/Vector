package org.trivial.vector.model;

import javafx.scene.paint.Paint;

public interface VectorObject {

    VectorObject create(double x, double y, Paint color);

    void draw(double x, double y, double lastX, double lastY);
}
