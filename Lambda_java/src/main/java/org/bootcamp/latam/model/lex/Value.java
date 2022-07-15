package org.bootcamp.latam.model.lex;

import java.util.List;

public class Value {
    private String originalValue;
    private List<String> resolvedValues;
    private String interpretedValue;

    public Value() {
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public List<String> getResolvedValues() {
        return resolvedValues;
    }

    public void setResolvedValues(List<String> resolvedValues) {
        this.resolvedValues = resolvedValues;
    }

    public String getInterpretedValue() {
        return interpretedValue;
    }

    public void setInterpretedValue(String interpretedValue) {
        this.interpretedValue = interpretedValue;
    }

    @Override
    public String toString() {
        return "Value{" +
                "originalValue='" + originalValue + '\'' +
                ", resolvedValues=" + resolvedValues +
                ", interpretedValue='" + interpretedValue + '\'' +
                '}';
    }
}
