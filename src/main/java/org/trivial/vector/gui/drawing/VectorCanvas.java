/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui.drawing;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.trivial.vector.Constants;
import org.trivial.vector.gui.optionsbar.OptionsBar;
import org.trivial.xc.utils.TrivialMath;

/**
 *
 * @author jpieles
 */
public class VectorCanvas extends Pane {

    private static Shape currentShape;
    Double lastX;
    Double lastY;

    public VectorCanvas() {
        setCanvasSettings();
        setCanvasEvents();
    }
    
    public static void setCurrentShape(Shape shape) {
        currentShape = shape;
    }

    private void setCanvasSettings() {
        this.setWidth(300);
        this.setHeight(200);
        this.setStyle(String.format("-fx-background-color:%s;", Constants.COLOR_2));
    }

    private void setCanvasEvents() {
        this.setOnMousePressed(e -> createObject(e.getX(), e.getY()));
        this.setOnMouseReleased(e -> drawObject(e.getX(), e.getY()));
        this.setOnMouseDragged(e -> updateShape(e.getX(), e.getY()));
    }

    private void updateShape(double x, double y) {
        if (currentShape.getClass() == Rectangle.class) {
            drawRectangle(x, y);
        }
        if (currentShape.getClass() == Circle.class) {
            drawCircle(x, y);
        }
        if (currentShape.getClass() == Line.class) {
            drawLine(x, y);
        }
    }

    private void createObject(double x, double y) {
        lastX = x;
        lastY = y;

        if(currentShape.getClass() == Rectangle.class) {
            createRect(x, y);
        }
        if(currentShape.getClass() == Circle.class) {
            createCircle(x, y);
        }
        if(currentShape.getClass() == Line.class) {
            createLine(x, y);
        }
    }

    private void createRect(double x, double y) {
        Rectangle rect = new Rectangle(x, y, 1, 1);
        rect.setFill(OptionsBar.colorPicker.getValue());
        currentShape = rect;
        this.getChildren().add(rect);
    }

    private void createCircle(double x, double y) {
        Circle circle = new Circle(x, y, 1);
        circle.setFill(OptionsBar.colorPicker.getValue());
        currentShape = circle;
        this.getChildren().add(circle);
    }

    private void createLine(double x, double y) {
        Line line = new Line(x, y, x, y);
        line.setFill(OptionsBar.colorPicker.getValue());
        currentShape = line;
        this.getChildren().add(line);
    }

    private void drawObject(double x, double y) {
        if (currentShape.getClass() == Rectangle.class) {
            drawRectangle(x, y);
        }
        if (currentShape.getClass() == Circle.class) {
            drawCircle(x, y);
        }
        if (currentShape.getClass() == Line.class) {
            drawLine(x, y);
        }
    }

    private void drawRectangle(double x, double y) {
        Rectangle rect = (Rectangle) currentShape;
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

    private void drawCircle(double x, double y) {
        double r = TrivialMath.pythagoras(TrivialMath.difference(x, lastX), TrivialMath.difference(y, lastY));
        Circle circle = (Circle) currentShape;
        circle.setRadius(r);
    }

    private void drawLine(double x, double y) {
        Line line = (Line) currentShape;
        line.setEndX(x);
        line.setEndY(y);
    }

    
}
