package broker.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@RestController
@RequestMapping(path = "/hello")
public class Controller {

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/users";
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHello() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody()); // all Array
        JsonNode name = root.path("name");
        System.out.println("Not sure but...: \n"+ root);
        return root.toString();
    }
}
