package co.istad.thymaleaf.thywepapp.repositiry;

import co.istad.thymaleaf.thywepapp.model.Article;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
public class StaticRepository {
    private Faker faker;
    private List<Article> articles;
@Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    @PostConstruct
    void init(){
        articles=new ArrayList<>(){{
            for (int i=0;i<20;i++){
                if(i%2==0){
                    add(new Article(UUID.randomUUID(),faker.book().title(),"03.jpg",faker.book().author()));
                }else {
                    add(new Article(UUID.randomUUID(),faker.book().title(),"02.jpg",faker.book().author()));
                }

            }

        }};
    }
}
