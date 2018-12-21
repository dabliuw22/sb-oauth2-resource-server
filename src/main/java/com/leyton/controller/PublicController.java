
package com.leyton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = {
            "/public"
        })
public class PublicController {

    @GetMapping(
            value = {
                "/message"
            })
    public ResponseEntity<String> publicMessage() {
        return ResponseEntity.ok("Public message");
    }
}
