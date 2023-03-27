/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.gui.drawing;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.trivial.vector.gui.optionsbar.OptionsBar;
import org.trivial.xc.utils.TrivialMath;

/**
 *
 * @author jpieles
 */
public class VectorCanvas extends Pane {

    public static Shape currentShape = new Rectangle(0,0,0,0);
    private static Shape selectedShape;
    private static Action action = Action.DRAW;

    Double lastX;
    Double lastY;

    public VectorCanvas() {
        setCanvasSettings();
        setCanvasEvents();
    }
    
    public static void setCurrentShape(Shape shape) {
        currentShape = shape;
    }

    public static void setAction(Action a) {
        action = a;
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
        if(action == Action.SELECT) {
            System.out.println("SELECT");
            for(Node s : this.getChildren()) {
                if(s.intersects(x, y, x, y)) {
                    selectedShape = (Shape) s;
                    System.out.println(s.getBoundsInLocal());
                    OptionsBar.text.setText(selectedShape.getBoundsInLocal().toString().replace(" ", "\n"));
                }
            }

            action = Action.DRAW;
            return;
        }

        if(action == Action.REMOVE) {
            for(Node s : this.getChildren()) {
                if(s.intersects(x, y, x, y)) {
                    this.getChildren().remove(s);
                }
            }

            action = Action.DRAW;
            return;
        }

        lastX = x;
        lastY = y;

        if(!this.intersects(x, y, x, y)) {
            return;
        }

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
        currentShape.fillProperty().bind(OptionsBar.colorPicker.valueProperty());
    }

    private void createCircle(double x, double y) {
        Circle circle = new Circle(x, y, 1);
        circle.setFill(OptionsBar.colorPicker.getValue());
        currentShape = circle;
        this.getChildren().add(circle);
    }

    private void createLine(double x, double y) {
        Line line = new Line(x, y, x, y);
        line.setStroke(OptionsBar.colorPicker.getValue());
        currentShape = line;
        this.getChildren().add(line);
    }

    private void drawObject(double x, double y) {
        if(action == Action.SELECT) {
            System.out.println("SELECT");
            for(Node s : this.getChildren()) {
                if(s.intersects(x, y, x, y)) {
                    selectedShape = (Shape) s;
                    System.out.println(s.getBoundsInLocal());
                    OptionsBar.text.setText(selectedShape.getBoundsInLocal().toString());
                }
            }

            action = Action.DRAW;
            return;
        }
        if(action == Action.REMOVE) {
            for(Node s : this.getChildren()) {
                if(s.intersects(x, y, x, y)) {
                    this.getChildren().remove(s);
                }
            }

            action = Action.DRAW;
            return;
        }

        if(!this.intersects(x,y,x,y)) {
            return;
        }

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
        if(!this.intersects(rect.getBoundsInLocal())) {
            return;
        }

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
