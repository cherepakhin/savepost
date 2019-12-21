package ru.dfsystems.savepost.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/log")
public class SavePostController {

    public final Logger logger = LoggerFactory.getLogger(SavePostController.class);

    @Value("${logging.file}")
    private String loggingFile;

    @GetMapping
    public ResponseEntity<String> getLog() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(loggingFile)));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(content);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody String req) {
        logger.info(String.format("{\"POST\": %s}", req));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body("");
    }
}
