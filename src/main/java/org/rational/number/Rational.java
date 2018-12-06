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

    private int gcd() {
        // greatest common divider
        int gcd = 1;


        return gcd;
    }

    public void Ged() {

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

        return this.numer * that.getDenom() == this.denom * that.getNumer();
    }

    @Override
    public String toString() {
        return String.format("%1$d / %2$d", this.numer, this.denom);
    }

    @Override
    public int compareTo(Rational rational) {


        return 0;
    }

    @Override
    public int intValue() {
        return (int)(this.numer / this.denom);
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
