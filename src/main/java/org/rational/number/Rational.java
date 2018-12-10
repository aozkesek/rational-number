package org.rational.number;

public class Rational extends Number implements Comparable<Rational> {

    private int numer;
    private int denom;

    public Rational(int numer, int denom) {
        if (denom == 0)
            throw new NumberFormatException("denominator can't be zero.");

        this.numer = numer;
        this.denom = denom;
    }

    public int getNumer() {
        return this.numer;
    }

    public int getDenom() {
        return this.denom;
    }

    // lowest common multiple
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // greatest common divider, 
    // Euclid's Algorithm
    private static int gcd(int a, int b) {
        int rem = 0;
        int dvs = 0;
        int dvd = 0;

        a = a < 0 ? a * -1 : a;
        b = b < 0 ? b * -1 : b;

        if (a > b) {
            dvd = a;
            dvs = b;     
        } else {
            dvd = b;
            dvs = a;
        }

        do {
            rem = dvd % dvs;
            if (rem > 0) {
                dvd = dvs;
                dvs = rem;
            }
        } while(rem > 0);

        return dvs;
    }

    public static int lcm(int a, int b, int... args) {

        int lcm = lcm(a, b);
        for (int i = 0; i < args.length; i++)
            lcm = lcm(lcm, args[i]);

        return lcm;
    }

    public static int gcd(int a, int b, int... args) {

        int gcd = gcd(a, b);
        for (int i = 0; i < args.length; i++)
            gcd = gcd(gcd, args[i]);
        
        return gcd;
    } 

    public int ged(Rational that) {
        return lcm(this.getDenom(), that.getDenom());
    }

    public int ged(Rational that, Rational... args) {
        int ged = lcm(this.getDenom(), that.getDenom());
        for (int i = 0; i < args.length; i++)
            ged = lcm(ged, args[i].getDenom());
        return ged;
    }

    public Rational add(Rational that) {
        return new Rational(this.numer * that.getDenom() + this.denom * that.getNumer()
                , this.denom * that.getDenom());
    }

    public Rational sub(Rational that) {
        return new Rational(this.numer * that.getDenom() - this.denom * that.getDenom()
                , this.denom * that.getDenom());
    }

    public Rational mul(Rational that) {
        return new Rational(this.numer * that.getNumer()
                , this.denom * that.getDenom());
    }

    public Rational div(Rational that) {
        return new Rational(this.numer * that.getDenom()
                , this.denom * that.getNumer());
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Rational))
            return false;

        Rational that = (Rational) obj;

        return (this.numer * that.getDenom()) == (this.denom * that.getNumer());
    }

    @Override
    public String toString() {
        return String.format("%1$d / %2$d", this.numer, this.denom);
    }

    @Override
    public int compareTo(Rational that) {

        int lcm = lcm(denom, that.getDenom());
        int thisNumer = numer * (lcm / denom);
        int thatNumer = that.getNumer() * (lcm / that.getDenom());

        if (thisNumer > thatNumer)
            return 1;
        else if (thisNumer == thatNumer)
            return 0;
        else
            return -1;
    }

    @Override
    public int intValue() {
        return this.numer / this.denom;
    }

    @Override
    public long longValue() {
        return (long)this.numer / (long)this.denom;
    }

    @Override
    public float floatValue() {
        return (float)this.numer / (float)this.denom;
    }

    @Override
    public double doubleValue() {
        return (double)this.numer / (double)this.denom;
    }
}
