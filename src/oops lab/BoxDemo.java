package com.example.college;

public class BoxDemo {
    public static void main(String[] args) {
        Box mybox = new 
        Box(); 
        double vol; 
        // assign values to mybox's instance variables  
        mybox.width = 10; 
        mybox.height = 20; 
        mybox.depth = 15; 
        // compute volume of box 
        vol = mybox.width * mybox.height * mybox.depth; 
        System.out.println("Volume is " + vol);
    }
}
class Box { 
    double width; 
    double height; 
    double depth; 
    void setDim(double w, double h, double d) { 
    width = w; 
    height = h; 
    depth = d; 
    } 
    void printvolume() { 
    System.out.print("Volume is ");  
    System.out.println(width * height * depth); 
    } 
    double volume() { 
    return width * height * depth; 
    } 
}