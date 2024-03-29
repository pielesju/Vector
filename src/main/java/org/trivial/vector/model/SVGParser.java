/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector.model;

import java.util.ArrayList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.trivial.vector.Constants;

/**
 *
 * @author jpieles
 */
public abstract class SVGParser {

    private SVGParser() {

    }

    public static String createSVGFile(ArrayList<Shape> objects) {
        StringBuilder svg = new StringBuilder(Constants.SVG_HEADER(320, 240));

        for (Shape s : objects) {
            svg.append(generateSVGFromObject(s));
        }

        svg.append(Constants.SVG_CLOSING_TAG);

        return svg.toString();
    }

    private static String generateSVGFromObject(Shape s) {
        if (s.getClass() == Rectangle.class) {
            
        }
        if (s.getClass() == Circle.class) {

        }
        if (s.getClass() == Line.class) {

        }
        
        return "";
    }

    public static ArrayList<Shape> createObjectField(String svg) {
        ArrayList<Shape> objects = new ArrayList<>();

        return objects;
    }

}
