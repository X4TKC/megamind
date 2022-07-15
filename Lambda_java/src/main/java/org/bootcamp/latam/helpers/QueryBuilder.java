package org.bootcamp.latam.helpers;

import org.bootcamp.latam.model.Input;
import org.bootcamp.latam.service.AthenaQueryExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class QueryBuilder {
    private String query;
    private String output="*";
    private String database="workshoplabkc";
    private String table="publication";
    private String limit="";
    private String input="";
    private StringBuilder stringBuilder;
    private Logger logger = LoggerFactory.getLogger(QueryBuilder.class);
    public QueryBuilder() {
        stringBuilder= new StringBuilder();
        query="";
    }
    public QueryBuilder buildOutput(List<String> output){
        StringBuilder stringBuilderOutput=new StringBuilder();
        for (String var:output
             ) {
            stringBuilderOutput.append(stringBuilderOutput.toString().equals("") ?var:","+var);
        }
        this.output= stringBuilderOutput.toString();
        return this;
    }
    public QueryBuilder buildInput(List<Input> inputs){
        StringBuilder stringBuilderInput=new StringBuilder();
        for (Input var:inputs
             ) {

            if(var.getName().equals("limit")){
                this.limit=var.getValue();
            }
            else{
               stringBuilderInput.append(stringBuilderInput.toString().equals("")?var.getName()+"='"+var.getValue()+"'":" AND "+var.getName()+"='"+var.getValue()+"'");
            }
        }
        this.input=stringBuilderInput.toString();
        return this;
    }
    public QueryBuilder buildQuery(){
        query="";
        stringBuilder=new StringBuilder();
        query=stringBuilder.append("Select ").append(output).append(" from ").append(database).append(".").append(table).append(input.equals("") ? input : " WHERE " + input).append(limit.equals("") ? limit : "limit " + limit).append(";").toString();
        return this;
    }
    public String build(){
        return query;
    }

}
