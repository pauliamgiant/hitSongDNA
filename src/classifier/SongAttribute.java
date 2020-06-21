package classifier;

public class SongAttribute {

    private String name;
    private Enum value;

    public SongAttribute(String name, Enum value) {
        this.name = name;
        this.value = value;
        }

    public String getName() {
        return name;
    }

    public Enum getValue() {
        return value;
    }
}

