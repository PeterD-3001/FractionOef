package be.teknyske;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by cerseilannister on 23/06/16.
 */
public class FractionTest {
    @Before
    public void initFraction()
    {
        System.out.println("START");
    }

    @Test
    public void createFractionNoSimplificationNeeded()
    {
        Fraction Breuk = new Fraction(1,2);
        System.out.println(Breuk.toString());
        assertEquals(1, Breuk.getNumerator() );
        assertEquals(2, Breuk.getDenominator() );
    }

    @Test
    public void createFractionWithSimplification()
    {
        Fraction Breuk = new Fraction(2,4);
        assertEquals(1, Breuk.getNumerator() );
        assertEquals(2, Breuk.getDenominator() );
        System.out.println(Breuk.toString());
    }

    @Test
    public void testSetNumeratorAndSimplify()
    {
        Fraction Breuk = new Fraction(1,4);
        Breuk.setNumerator(2);
        assertEquals("{ 1 / 2 }", Breuk.toString());
        System.out.println(Breuk.toString());
    }

    @Test
    public void testSetDenominatorAndSimplify()
    {
        Fraction breuk = new Fraction(2,5);
        breuk.setDenominator(8);
        assertEquals("{ 1 / 4 }", breuk.toString());
        System.out.println(breuk.toString());
    }

    @Test
    public void testFractionToString()
    {
        Fraction breuk = new Fraction(4,12);
        System.out.println(breuk.toString());
        assertEquals("{ 1 / 3 }", breuk.toString());
    }

    @Test
    public void testFractionAddition()
    {
        Fraction Breuk1 = new Fraction(1,2);
        System.out.println(Breuk1.toString());
        Fraction Breuk2 = new Fraction(3,4);
        System.out.println(Breuk2.toString());

        Fraction Som = Breuk1.add(Breuk2);
        assertEquals(5, Som.getNumerator() );
        assertEquals(4, Som.getDenominator() );
        System.out.println(Som);
    }

    @Test
    public void testFractionMultiplication()
    {
        Fraction Breuk1 = new Fraction(1,2);
        System.out.println(Breuk1.toString());
        Fraction Breuk2 = new Fraction(3,4);
        System.out.println(Breuk2.toString());

        Fraction Som = Breuk1.multiply(Breuk2);
        assertEquals(3, Som.getNumerator() );
        assertEquals(8, Som.getDenominator() );
        System.out.println(Som);
    }

    @Test
    public void testFractionDivision()
    {
        Fraction Breuk1 = new Fraction(1,2);
        System.out.println(Breuk1.toString());
        Fraction Breuk2 = new Fraction(3,4);
        System.out.println(Breuk2.toString());

        Fraction Quotient = Breuk1.divide(Breuk2);
        assertEquals(2, Quotient.getNumerator() );
        assertEquals(3, Quotient.getDenominator() );
        System.out.println(Quotient);
    }

    @Test
    public void testFractionInversion()
    {
        Fraction Breuk1 = new Fraction(1,2);
        System.out.println(Breuk1.toString());

        Fraction Inverted = Breuk1.invert();
        assertEquals(2, Inverted.getNumerator() );
        assertEquals(1, Inverted.getDenominator() );
        System.out.println(Inverted);
    }

    @Test
    public void testDefaultFractionConstructor()
    {
        Fraction Breuk1 = new Fraction();
        System.out.println(Breuk1.toString());
        assertEquals(1, Breuk1.getNumerator() );
        assertEquals(1, Breuk1.getDenominator() );
    }

    @Test
    public void testFractionIsNegative()
    {
        Fraction Breuk1 = new Fraction(3,7);
        System.out.println(Breuk1.toString());
        assertFalse(Breuk1.isNegative());

        Fraction Breuk2 = new Fraction(-13,21);
        System.out.println(Breuk2.toString());
        assertTrue(Breuk2.isNegative());

        Fraction Breuk3 = new Fraction(13,-83);
        System.out.println(Breuk3.toString());
        assertTrue(Breuk3.isNegative());

        Fraction Breuk4 = new Fraction(-17,-83);
        System.out.println(Breuk4.toString());
        assertFalse(Breuk4.isNegative());
    }

}