package org.bootcamp.latam.model.lex;

import java.util.ArrayList;
import java.util.List;

public class SlotObject {
    private String shape;
    private Value value;
    private List<Values> values;

    public SlotObject() {
        value=new Value();
        values=new ArrayList<>();
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

    public List<Values> getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "SlotObject{" +
                "shape='" + shape + '\'' +
                ", value=" + value +
                ", values=" + values +
                '}';
    }
}
