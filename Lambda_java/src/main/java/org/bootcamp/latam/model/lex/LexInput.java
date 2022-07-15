package org.bootcamp.latam.model.lex;

import java.util.ArrayList;
import java.util.List;

public class LexInput {
    private String sessionId;
    private String inputTranscript;
    private List<Interpretations> interpretations;
    private String responseContentType;
    private String invocationSource;
    private String messageVersion;
    private List<Transcriptions> transcriptions;
    private SessionState sessionState;
    private String inputMode;
    private Bot bot;

    public LexInput() {
        interpretations=new ArrayList<>();
        transcriptions= new ArrayList<>();
        sessionState=new SessionState();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getInputTranscript() {
        return inputTranscript;
    }

    public void setInputTranscript(String inputTranscript) {
        this.inputTranscript = inputTranscript;
    }

    public List<Interpretations> getInterpretations() {
        return interpretations;
    }

    public void setInterpretations(List<Interpretations> interpretations) {
        this.interpretations = interpretations;
    }

    public String getResponseContentType() {
        return responseContentType;
    }

    public void setResponseContentType(String responseContentType) {
        this.responseContentType = responseContentType;
    }

    public String getInvocationSource() {
        return invocationSource;
    }

    public void setInvocationSource(String invocationSource) {
        this.invocationSource = invocationSource;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public List<Transcriptions> getTranscriptions() {
        return transcriptions;
    }

    public void setTranscriptions(List<Transcriptions> transcriptions) {
        this.transcriptions = transcriptions;
    }

    public SessionState getSessionState() {
        return sessionState;
    }

    public void setSessionState(SessionState sessionState) {
        this.sessionState = sessionState;
    }

    public String getInputMode() {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    @Override
    public String toString() {
        return "LexInput{" +
                "sessionId='" + sessionId + '\'' +
                ", inputTranscript='" + inputTranscript + '\'' +
                ", interpretations=" + interpretations +
                ", responseContentType='" + responseContentType + '\'' +
                ", invocationSource='" + invocationSource + '\'' +
                ", messageVersion='" + messageVersion + '\'' +
                ", transcriptions=" + transcriptions +
                ", sessionState=" + sessionState +
                ", inputMode='" + inputMode + '\'' +
                ", bot=" + bot +
                '}';
    }
}
