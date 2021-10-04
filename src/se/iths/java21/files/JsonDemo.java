package se.iths.java21.files;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonDemo {
    public static void main(String[] args) {
        List<Cake> cake = List.of(
                new Cake(1, "KanelBulle", 20),
                new Cake(2, "KanelBullea", 15),
                new Cake(3, "KanelBulles", 25)
        );
        JsonDemo jsonDemo = new JsonDemo();
        String json = jsonDemo.toJson(cake);
        System.out.println(json);

        List<Cake> jsonCakesList = jsonDemo.fromJson(json);
        jsonCakesList.forEach(System.out::println);
    }


    private  String toJson(List<Cake> cakes){
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(cakes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    private List<Cake> fromJson(String jsonData){
        return List.of();
    }
}
