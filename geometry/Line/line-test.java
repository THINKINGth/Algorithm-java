/**
 *
 * FUNCTION:  求两条直线的公共交点
 *    Error:1.在编写Lines类时错误的将db的值付给了c，使得b始终等于c
 * QUESTION:1.在编写程序时没有做相应的准备
 *     TIME:2018.5.25
 */
package com.company;
import java.util.*;
public class line-test {
    public static void main(String[] args){
        double x,y;
        Scanner in = new Scanner(System.in);
        Line[] lines = new Line[2];
        for(int i = 0;i <=1;i++){
            System.out.println("Please input a,b,c values: ");
            lines[i] = new Line(in.nextDouble(),in.nextDouble(),in.nextDouble());
        }
        //ax+by+c=0
        if((lines[0].getBoolK()) && (lines[1].getBoolK())&&(lines[0].getK() - lines[1].getK() != 0)) {
            x = (lines[0].getB() * lines[1].getC() - lines[1].getB() * lines[0].getC())
                    /  (lines[0].getA() * lines[1].getB() - lines[1].getA() * lines[0].getB());
            y = (lines[0].getA() * lines[1].getC() - lines[1].getA() * lines[0].getC())
                    /  (lines[1].getA() * lines[0].getB() - lines[0].getA() * lines[1].getB());
            System.out.println("x: "+ x +"\ny: "+ y);
        }
        //a,b vertical x
        else if(lines[0].getBoolK()) {
            if (lines[1].getBoolK()) {
                //平行
                System.out.println("Parallel");
            }
            else{
                x = -(lines[1].getC()/lines[1].getA());
                y = (lines[0].getA()/lines[0].getB())*
                          ((lines[0].getA()*lines[1].getC()-lines[1].getA()*lines[0].getC())/ (lines[0].getA()*lines[1].getA()));
                System.out.println("x: "+ x +"\ny: "+ y);

            }
        }
        else if(!(lines[0].getBoolK())) {
            if (!(lines[1].getBoolK())) {
                if ((lines[0].getC() / lines[0].getA()) == (lines[1].getC() / lines[1].getA())) {
                    //重合
                    System.out.println("Coincidence");
                } else {
                    //平行且垂直于x轴
                    System.out.println("Parallel");
                }
            } else {
                x = -(lines[0].getC()/lines[0].getA());
                y = (lines[1].getA()/lines[1].getB()) *
                          ((lines[1].getA()*lines[0].getC()-lines[0].getA()*lines[1].getC())/(lines[0].getA() * lines[1].getA()));
                System.out.println("x: " + x + "\ny: " + y);
            }
        }
    }
}
class Line{
    private double a;
    private double b;
    private double c;
    private double k;

    public Line(double da,double db,double dc){
        a = da;
        b = db;
        c = dc;
    }
    public boolean getBoolK(){
        if(b != 0){
            return true;
        }
        return false;
    }

    public double getK(){

        return k = a/b;

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
