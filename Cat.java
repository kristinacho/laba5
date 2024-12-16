public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    @Override
    public void meow() {
    }
    public String getName() {
        return name;
    }
}
