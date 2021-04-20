package hu.corvinus.harmadik;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/harmadik")
public class MessageController {

    @GetMapping("")
    public SimpleResponse greeting(@RequestParam(required = false) String name){
        String response;

        if(name != null){
            response = String.format("Hello %s", name);
        }
        else {
            response = "Hello Felhasznalo";
        }
        return SimpleResponse.builder().content(response).build();
    }

    @PostMapping("/megfordit")
    public SimpleResponse reverseMessage(@RequestParam(required = false) String message){
        String response = "Alma a fa alatt";
        if (message != null){
            response = message;
        }
        response = new StringBuffer(response).reverse().toString();
        return SimpleResponse.builder().content(response).build();
    }


}
