package hu.corvinus.harmadik.controller;

import hu.corvinus.harmadik.controller.dto.SimpleResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/harmadik")
public class MessageController {

    @GetMapping("")
    public SimpleResponse greeting(@RequestParam(defaultValue = "Felhasznalo") String name){

        String response = String.format("Hello %s", name);
        return SimpleResponse.builder()
                .content(response)
                .build();
    }

    @PostMapping("")
    public SimpleResponse reverseMessage(@RequestBody(required = false) String text){

        if(text == null){
            text="Alma a fa alatt";
        }

        String response = new StringBuffer(text).reverse().toString();
        return SimpleResponse.builder()
                .content(response)
                .build();
    }


}
