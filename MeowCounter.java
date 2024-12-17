public class MeowCounter {
    private int meowCount = 0;// Счетчик мяуканий
    private Meowable cat;

    public MeowCounter(Meowable cat){
        this.cat = cat;
    }

    public void countMeows() {
            cat.meow();
            meowCount++;
    }
    public int getMeowCount() {
        return meowCount;
    }
}
