package com.example.powernine.search;

import com.example.powernine.document.Search;
import com.example.powernine.document.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Repository
public class searchRepository implements CardDAL{
    private final MongoTemplate mongoTemplate;


    @Autowired
    public searchRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Card> getSearch(Search search) {
        Query query= new Query();
        if (search.getName()!=null && !search.getName().equals("")){
            query.addCriteria(Criteria.where("name").regex(".*"+search.getName()+".*"));
        }
        if (search.getColor()!=null && search.getColor().length>0){

            if (search.getMatching().equals("exactly")){
                Vector<String> colors = new Vector<>();
                colors.add("W");
                colors.add("U");
                colors.add("B");
                colors.add("R");
                colors.add("G");
                int length = search.getColor().length;
                Criteria[] c= new Criteria[5];
                for (int i =0;i<length;i++){
                    c[i]= Criteria.where("colors").in(search.getColor()[i]);
                    colors.remove(search.getColor()[i]);
                }
                for (int i =0;i+length<5;i++){
                    c[i+length]= Criteria.where("colors").nin(colors.get(i));
                }
                Criteria andOp= new Criteria();
                andOp.andOperator(c);
                query.addCriteria(andOp);
            }
            else{
                int length = search.getColor().length;
                Criteria[] c= new Criteria[length];
                for (int i =0;i<length;i++){
                    c[i]= Criteria.where("colors").in(search.getColor()[i]);
                }
                Criteria orOp= new Criteria();
                orOp.orOperator(c);
                query.addCriteria(orOp);
            }
        }
        if (search.getStatType()!=null && !search.getStatType().equals("")) {
            switch (search.getStatMatching()) {
                case "exactly":
                    query.addCriteria(Criteria.where(search.getStatType()).is(search.getStat()));
                    break;
                case "greater":
                    query.addCriteria(Criteria.where(search.getStatType()).gt(search.getStat()));
                    break;
                case "less":
                    query.addCriteria(Criteria.where(search.getStatType()).lt(search.getStat()));
                    break;
                case "GreaterEqual":
                    query.addCriteria(Criteria.where(search.getStatType()).gte(search.getStat()));
                    break;
                case "LessEqual":
                    query.addCriteria(Criteria.where(search.getStatType()).lte(search.getStat()));
                    break;
            }
        }
        if (search.getRarity()!=null && search.getRarity().length>0){
            query.addCriteria(Criteria.where("rarity").is(search.getRarity()[0]));
        }
        /*if (search.getRarity()!=null && search.getRarity().length>0){


                int rLength = search.getRarity().length;
                Criteria[] rc= new Criteria[rLength];
                for (int i =0;i<rLength;i++){
                    rc[i]= Criteria.where("rarity").is(search.getRarity()[i]);
                }
                Criteria rOrOp= new Criteria();
                rOrOp.orOperator(rc);
                query.addCriteria(rOrOp);

        }*/

       if (query.equals(new Query())){
           return new ArrayList<Card>();
       }
       else {
           return mongoTemplate.find(query, Card.class);
       }


    }
}
