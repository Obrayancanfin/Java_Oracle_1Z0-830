package org.example.demojee;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/")

public class GameRessources {



    @GET
    @Path("/quizzes")
    @Produces("text/plain")
    public String getQuizz(){
        Map<String, String> setupQuestion = new HashMap<String,String>();
        setupQuestion.put("Johnny Walker", "2178");
        Question question1 = new Question((HashMap<String, String>) setupQuestion,"",false) ;
        List<Question> listQuestion = new ArrayList<>();
        listQuestion.add(question1);
        Quizz quizz1 = new Quizz(listQuestion);
        return Quizz.ShowQuizzes();
    }

}
