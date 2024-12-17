public class CachedFraction implements FractionInterface {
    private final Fraction fraction;
    private Double cachedRealValue;

    public CachedFraction(Fraction fraction) {
        this.fraction = fraction;
        this.cachedRealValue = null;
    }

    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = fraction.getRealValue(); 
        }
        return cachedRealValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        cachedRealValue = null; 
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        cachedRealValue = null; 
    }

    @Override
    public String toString() {
        return fraction.toString(); 
    }
}
