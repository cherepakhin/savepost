package ru.dfsystems.savepost.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class SavePostController {
    public Logger logger = LoggerFactory.getLogger(SavePostController.class);

    @Value( "${logging.file}" )
    private String loggingfile;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> get() throws Exception {
        String content = "";
        content = new String ( Files.readAllBytes( Paths.get(loggingfile) ) );
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(content);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody String req) throws Exception {
        logger.info("{\"POST\":" + req+"}\n");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body("");
    }
}
