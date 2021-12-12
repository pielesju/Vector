/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trivial.xc.utils;

/**
 *
 * @author jpieles
 */
public class TrivialMath {
    
    public static Double difference(double a, double b) {
        double min = Math.min(a, b);
        double max = Math.max(a, b);
        
        return max-min;
    }
    
    public static Double pythagoras(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    
}
