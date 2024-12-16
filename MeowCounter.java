public class MeowCounter {
    private int meowCount = 0; // Счетчик мяуканий

    public void countMeows(Meowable meowable, int times) {
        for (int i = 0; i < times; i++) {
            meowable.meow();
            meowCount++;
        }
    }
    public int getMeowCount() {
        return meowCount;
    }
}
