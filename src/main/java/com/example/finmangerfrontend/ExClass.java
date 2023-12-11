package com.example.finmangerfrontend;

import java.util.HashSet;
import java.util.Objects;

public class ExClass {
    public static void main( String[] args ) {
        Figure figure = new Figure(1,1);
        Figure figure2 = new Figure(2,2);
        Figure figure3 = new Figure( 1, 1 );
        System.out.println(figure==figure3);
        System.out.println(figure.equals( figure3));

        HashSet<Figure> figures = new HashSet<>();
        figures.add( figure );
        figures.add( figure2 );
        figures.add( figure3 );
        System.out.println(figures);
        figure.setX( 3 );
        figure.setY( 3 );
        System.out.println(figures.contains( new Figure( 3,3 ) ));




        System.exit( 0 );

        figure.setX( 2 );
        figure.setY( 2 );
//        figure2.setX( 1 );
//        figure2.setY( 1 );
        figures.add( figure3 );
        System.out.println(figures);
    }

}

class Figure {
    private int x;
    private int y;

    public Figure( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Figure figure = (Figure) o;
        return x == figure.x && y == figure.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash( x, y );
    }

    public int getX() {
        return x;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY( int y ) {
        this.y = y;
    }
}
