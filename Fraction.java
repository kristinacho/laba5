import java.util.Objects;

public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;
    private Double cachedRealValue;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        reduce();
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    @Override
    public String toString() {
        if (numerator == 0) {
            return "0";
        }
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator; // Кэшируем значение
        }
        return cachedRealValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedRealValue = null;
        reduce();
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
        cachedRealValue = null;
        reduce();
    }

    // Сложение дробей
    public Fraction sum(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Вычитание дробей
    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Умножение дробей
    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    // Деление дробей
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

}
