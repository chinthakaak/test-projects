package com.examples;

/**
 * Created by ka40215 on 7/20/15.
 */
public class CalcService {
    public ICalc getCalc() {
        return calc;
    }

    public void setCalc(ICalc calc) {
        this.calc = calc;
    }

    ICalc calc;

    public int addN(int a, int b){
        return calc.add(a,b);
    }
}
