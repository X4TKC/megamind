package org.bootcamp.latam.model.lex;

public class Slots {
    private SlotObject output;
    private SlotObject argsTwo;
    private SlotObject args;
    private SlotObject column;
    private SlotObject column2;

    public Slots() {
        output = new SlotObject();
        argsTwo = new SlotObject();
        args = new SlotObject();
        column = new SlotObject();
        column2 = new SlotObject();
    }

    public SlotObject getOutput() {
        return output;
    }

    public void setOutput(SlotObject output) {
        this.output = output;
    }

    public SlotObject getArgsTwo() {
        return argsTwo;
    }

    public void setArgsTwo(SlotObject argsTwo) {
        this.argsTwo = argsTwo;
    }

    public SlotObject getArgs() {
        return args;
    }

    public void setArgs(SlotObject args) {
        this.args = args;
    }

    public SlotObject getColumn() {
        return column;
    }

    public void setColumn(SlotObject column) {
        this.column = column;
    }

    public SlotObject getColumn2() {
        return column2;
    }

    public void setColumn2(SlotObject column2) {
        this.column2 = column2;
    }

    @Override
    public String toString() {
        return "Slots{" +
                "output=" + output +
                ", argsTwo=" + argsTwo +
                ", args=" + args +
                ", column=" + column +
                ", column2=" + column2 +
                '}';
    }
}
