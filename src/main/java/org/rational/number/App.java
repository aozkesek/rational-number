
package org.rational.number;

import java.util.Arrays;

import static java.lang.System.out;

public class App {

    public static void main(String[] args) {
        Rational a = new Rational(1, 4);
        Rational b = new Rational(5, 3);

        out.println(Rational.gcd(5, 32));
        out.println(Rational.gcd(24, 18));
        out.println(Rational.gcd(24, 36, 41));
        out.println(Rational.gcd(24, 36, 48));

        out.println(Rational.lcm(5, 2));
        out.println(Rational.lcm(8, 4));
        out.println(Rational.lcm(7, 6));
        out.println(Rational.lcm(2, 3, 6, 8));

        out.println(a.ged(b));
        out.println(a.ged(b, new Rational(2, 5), new Rational(5, 6)));

        out.println(a + " + " + b + " = " + a.add(b));
        out.println(a + " - " + b + " = " + a.sub(b));
        out.println(a + " * " + b + " = " + a.mul(b));
        out.println(a + " / " + b + " = " + a.div(b));

        Rational[] arr = {new Rational(7, 1), new Rational(6, 1),
                          new Rational(5, 1), new Rational(4, 1),
                          new Rational(3, 1), new Rational(2, 1),
                          new Rational(1, 1), new Rational(1, 2),
                          new Rational(1, 3), new Rational(1, 4),
                          new Rational(1, 5), new Rational(1, 6),
                          new Rational(1, 7), new Rational(1, 8),
                          new Rational(1, 9), new Rational(0, 1)};

        Arrays.sort(arr);

        for (Rational r : arr) {
            System.out.println(r);
        }

        Number n = new Rational(3, 2);

        out.println(n.doubleValue());
        out.println(n.floatValue());
        out.println(n.intValue());
        out.println(n.longValue());


        out.println(n.equals(new Rational(6, 4)));
        out.println(n.equals(new Rational(6, 3)));
        out.println(n.equals(new Rational(-6, 4)));


    }
}
