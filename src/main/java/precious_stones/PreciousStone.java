package precious_stones;

public class PreciousStone {
    private String name;
    private int pricePerCarat;
    private double weight;
    double transparency;
    private String type;

    public PreciousStone(String name, int pricePerCarat, double weight, String type) {
        this.name = name;
        this.pricePerCarat = pricePerCarat;
        this.weight = weight;
//        while (transparency > 1 || transparency < 0){
//            System.out.printf("invalid transparency for %s %s write new",name,this.getClass().getSimpleName());
//            double x = new Scanner(System.in).nextDouble();
//        }

    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getPricePerCarat() {
        return pricePerCarat;
    }

    protected void setPricePerCarat(int pricePerCarat) {
        this.pricePerCarat = pricePerCarat;
    }

    public double getWeight() {
        return weight;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PreciousStone{" +
                "name='" + name + '\'' +
                ", pricePerCarat=" + pricePerCarat +
                ", weight=" + weight +
                ", transparency=" + transparency +
                '}';
    }
}
