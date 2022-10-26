package precious_stones;

public class PreciousStoneBuilder {
    private String name = null;
    private int pricePerCarat = 0;
    private int weight = 0;
    private double transparency = -1;
    private StoneType type = null;

    public PreciousStoneBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PreciousStoneBuilder setPricePerCarat(int pricePerCarat) {
        this.pricePerCarat = pricePerCarat;
        return this;
    }

    public PreciousStoneBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public PreciousStoneBuilder setTransparency(double transparency) {
        this.transparency = transparency;
        return this;
    }

    public PreciousStoneBuilder setType(StoneType type) {
        this.type = type;
        return this;
    }

    public PreciousStone build (){
        return new PreciousStone(this.name,this.pricePerCarat,this.weight,this.transparency, this.type);
    }
}
