package org.bootcamp.latam.helpers;

import org.bootcamp.latam.model.Param;
import org.bootcamp.latam.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QueryManager {
    private Param param;
    private QueryBuilder queryBuilder;
    private List<String> queries;
    public QueryManager(Param param) {
        this.param = param;
        queryBuilder=new QueryBuilder();
        queries= new ArrayList<>();
    }
    public List<String> getQuery(){
        for (Question question:param.getQuestions()
             ) {
            queries.add(queryBuilder.buildOutput(question.getOutput()).buildInput(question.getInput()).buildQuery().build());
        }

        return queries;        
    }
}
