public class CachedFraction implements FractionInterface {
    private final Fraction fraction;
    private Double cachedRealValue;

    public CachedFraction(Fraction fraction) {
        this.fraction = fraction;
        this.cachedRealValue = null; // Изначально кэш пуст
    }

    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = fraction.getRealValue(); // Кэшируем значение
        }
        return cachedRealValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        cachedRealValue = null; // Сбрасываем кэш при изменении числителя
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        cachedRealValue = null; // Сбрасываем кэш при изменении знаменателя
    }

    @Override
    public String toString() {
        return fraction.toString(); // Возвращаем строковое представление дроби
    }
}
