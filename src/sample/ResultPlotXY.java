package sample;

import javafx.fxml.FXML;

import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class ResultPlotXY {
    private int step; // ненужная переменная

    private double x;

    private double y;

    ResultPlotXY(){
    }

    ResultPlotXY(int step,double x){
        this.x = x;
        this.y = log(x) * sin(x);
        this.step = step;
    }

    public void setStep(int step){this.step = step;}

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getStep() {
        return step;
    }
}
