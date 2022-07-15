package org.bootcamp.latam.model.lex;

import org.bootcamp.latam.model.lex.Intent;

public class Interpretations {
    private Intent intent;
    private double nluConfidence;

    public Interpretations() {
        intent=new Intent();
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public double getNluConfidence() {
        return nluConfidence;
    }

    public void setNluConfidence(double nluConfidence) {
        this.nluConfidence = nluConfidence;
    }

    @Override
    public String toString() {
        return "Interpretations{" +
                "intent=" + intent +
                ", nluConfidence=" + nluConfidence +
                '}';
    }
}
