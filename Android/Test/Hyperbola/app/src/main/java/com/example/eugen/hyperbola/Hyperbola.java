package com.example.eugen.hyperbola;

/**
 * Created by Eugen on 25.11.2016.
 */

public class Hyperbola {
    private double _x;
    private double _y;

    public Hyperbola(double x, double y){
        _x = x;
        _y = y;
    }

    public static Hyperbola calculateX(double y){
        return new Hyperbola(Math.sqrt(y), y);
    }

    public static Hyperbola calculateY(double x){
        return new Hyperbola(x, Math.pow(x,2));
    }

    @Override
    public String toString() {
        return "Hyperbola{" +
                "x=" + _x +
                ", y=" + _y +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainActivity that = (MainActivity) o;

        if (_editX != null ? !_editX.equals(that._editX) : that._editX != null) return false;
        if (_editY != null ? !_editY.equals(that._editY) : that._editY != null) return false;
        return _result != null ? _result.equals(that._result) : that._result == null;

    }

    @Override
    public int hashCode() {
        int result = _editX != null ? _editX.hashCode() : 0;
        result = 31 * result + (_editY != null ? _editY.hashCode() : 0);
        result = 31 * result + (_result != null ? _result.hashCode() : 0);
        return result;
    }
}
