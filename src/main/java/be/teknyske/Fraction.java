package be.teknyske;

import com.realdolmen.Utilities;


/**
 * Created by cerseilannister on 23/06/16.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.simplify();
    }

    public Fraction() {
        this(1,1);
    }

    // Gettters Setters
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        this.simplify();
    }

    @Override
    public String toString() {
        return "{ " + numerator + " / " + denominator +" }";
    }

     // Simplify
    private void simplify(){
        int ggd = Utilities.greatestCommonFactor(this.numerator,this.denominator);
        this.numerator   /= ggd;
        this.denominator /= ggd;
    }

    // Rekeneuhn met...
    public Fraction add(Fraction that)
    {
        int teller = (this.numerator * that.denominator)+(that.numerator * this.denominator);
        int noemer = this.denominator * that.denominator;
        return new Fraction (teller, noemer);
    }

    public Fraction multiply(Fraction that)
    {
       return new Fraction (this.numerator * that.numerator, this.denominator * that.denominator);
    }

    public Fraction invert()
    {
        return new Fraction (this.denominator, this.numerator);
    }

    public Fraction divide(Fraction that)
    {
        return (this.multiply(that.invert()));
    }

    //Test-functie
    public boolean isNegative()
    {
       return ( (this.numerator < 0) ^ (this.denominator < 0) );
    }





}
