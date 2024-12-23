package TriPrism;

class TriPrism<T extends Number> {
    private T length;
    private T base;
    private T height;

    // Constructor
    public TriPrism(T length, T base, T height) {
        this.length = length;
        this.base = base;
        this.height = height;
    }

    // Getter and Setter for length
    public T getLength() {
        return length;
    }

    public void setLength(T length) {
        this.length = length;
    }

    // Getter and Setter for base
    public T getBase() {
        return base;
    }

    public void setBase(T base) {
        this.base = base;
    }

    // Getter and Setter for height
    public T getHeight() {
        return height;
    }

    public void setHeight(T height) {
        this.height = height;
    }

    // Method to calculate volume
    public double calculateVolume() {
        double lengthValue = length.doubleValue();
        double baseValue = base.doubleValue();
        double heightValue = height.doubleValue();
        return lengthValue * (0.5 * baseValue * heightValue);
    }

    public static void main(String[] args) {
        // Example usage
        TriPrism<Double> prism = new TriPrism<>(10.0, 5.0, 4.0);
        System.out.println("Volume of the triangular prism: " + prism.calculateVolume());
    }
}
