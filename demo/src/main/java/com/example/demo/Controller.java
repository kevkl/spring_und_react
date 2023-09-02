package com.example.demo;


import Wertpapier.Wertpapierservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;


@RestController
public class Controller {

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(path = "/1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity createClient() throws URISyntaxException, IOException {
        Wertpapierservice ws = new Wertpapierservice("https://www.onvista.de/aktien/kennzahlen/");

        return ResponseEntity.status(HttpStatus.OK).body(

                ws.getWertpapierkennzahlen()


        );
    }
}
