package org.bootcamp.latam.model.lex;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private SessionState sessionState;
    private List<Messages> messages;

    public Output() {
        sessionState=new SessionState();
        messages= new ArrayList<>();
    }

    public SessionState getSessionState() {
        return sessionState;
    }

    public void setSessionState(SessionState sessionState) {
        this.sessionState = sessionState;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Output{" +
                "sessionState=" + sessionState +
                ", messages=" + messages +
                '}';
    }
}
