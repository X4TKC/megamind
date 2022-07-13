package org.bootcamp.latam.helpers;

import org.bootcamp.latam.model.Input;

import java.util.List;

public class QueryBuilder {
    private String query;
    private String output="*";
    private String database="workshoplabkc";
    private String table="publication";
    private String limit="";
    private String input="";
    private StringBuilder stringBuilder;
    public QueryBuilder() {
        stringBuilder= new StringBuilder();
        query=stringBuilder.append("Select "+output+" from "+database+"."+table).toString();
    }
    public QueryBuilder buildOutput(List<String> output){
        String result="";
        for (String var:output
             ) {
            result=stringBuilder.append(result.equals("") ?var:result+","+var).toString();
        }
        this.output= stringBuilder.append(result).toString();
        return this;
    }
    public QueryBuilder buildInput(List<Input> inputs){
        for (Input var:inputs
             ) {
            if(var.getName().equals("limit")){
                this.limit=stringBuilder.append(var.getValue()).toString();
            }
            else{
                this.input=stringBuilder.append(this.input.equals("")?var.getName()+"='"+var.getValue()+"'":" AND "+var.getName()+"='"+var.getValue()+"'").toString();
            }
        }
        return this;
    }
    public QueryBuilder buildQuery(){
        query=stringBuilder.append("Select "+output+" from "+database+"."+table+(input.equals("")?input:" WHERE "+input)
                +(limit.equals("")?limit:"limit "+ limit)+";").toString();
        return this;
    }
    public String build(){
        return query;
    }

}
