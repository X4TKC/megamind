package org.bootcamp.latam.model.lex;

public class Values {
    private String shape;
    private Value value;

    public Values() {
        value=new Value();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Values{" +
                "shape='" + shape + '\'' +
                ", value=" + value +
                '}';
    }
}
