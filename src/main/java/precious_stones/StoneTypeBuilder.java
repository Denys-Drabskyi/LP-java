package precious_stones;

public class StoneTypeBuilder {
    private String name = null;
    private int value = -1;

    public StoneType build(){
        return new StoneType(name,value);
    }

    public StoneTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StoneTypeBuilder setValue(int value) {
        this.value = value;
        return this;
    }
}
