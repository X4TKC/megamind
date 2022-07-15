package org.bootcamp.latam.model.lex;



public class Intent {
    private Slots slots;
    private String confirmationState;
    private String name;
    private String state;


    public Intent() {
        slots=new Slots();
    }

    public Slots getSlots() {
        return slots;
    }

    public void setSlots(Slots slots) {
        this.slots = slots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConfirmationState() {
        return confirmationState;
    }

    public void setConfirmationState(String confirmationState) {
        this.confirmationState = confirmationState;
    }

    @Override
    public String toString() {
        return "Intent{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", confirmationState='" + confirmationState + '\'' +
                ", slots=" + slots +
                '}';
    }
}
