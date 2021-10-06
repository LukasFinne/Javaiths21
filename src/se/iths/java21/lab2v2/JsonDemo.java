package se.iths.java21.lab2v2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import se.iths.java21.files.Cake;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonDemo {
    public static void main(String[] args) throws IOException {
        List<ProductsInfo> cake = List.of(
                new ProductsInfo("3", 10, Category.MEAT,1001, "ica" ,25));
        JsonDemo jsonDemo = new JsonDemo();
        String json = jsonDemo.toJson(cake);
        System.out.println(json);

        String homeFolder = System.getProperty("user.home");
        Path path = Path.of(homeFolder, "ProductsInfo.json");
        Files.writeString(path, json);


        List<ProductsInfo> jsonCakesList = jsonDemo.fromJson(json);
        jsonCakesList.forEach(System.out::println);
    }


    private  String toJson(List<ProductsInfo> cakes){
        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(cakes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    private List<ProductsInfo> fromJson(String jsonData){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonData, new TypeReference<>(){});//TypeRefernce är för att type erasure
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
