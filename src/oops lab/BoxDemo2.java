package com.example.college;

public class BoxDemo2 {
    public static void main(String[] args) {
        Box mybox1 = new 
        Box(); 
        Box mybox2 =new Box();
        double vol1; 
        double vol2; 
        // assign values to mybox1's instance variables  
        mybox1.width = 10; 
        mybox1.height = 20; 
        mybox1.depth = 15; 
        // assign values to mybox2's instance variables
        mybox2.width = 40; 
        mybox2.height = 25; 
        mybox2.depth = 15; 
        // compute volume of box1 
        vol1 = mybox1.width * mybox1.height * mybox1.depth; 
        // compute volume of box2 
        vol2=mybox2.width * mybox2.height * mybox2.depth; 
        System.out.println("Volume of box1 is " + vol1+" "+"volume of box2 is"+vol2);

    }
}
