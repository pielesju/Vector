/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.vector;

/**
 *
 * @author jpieles
 */
public class Constants {
    
    public static final double WINDOW_WIDTH = 640;
    public static final double WINDOW_HEIGHT = 480;
    
    public static final String SVG_HEADER(double windowWidth, double windowHeight) {
        return "<svg version=\"1.1\"width =\"" + windowWidth + "\" height=\"" + 200 + "\"xmlns =\"http://www.w3.org/2000/svg\">\n";
    }
    public static final String SVG_CLOSING_TAG = "</svg>";
    
}
