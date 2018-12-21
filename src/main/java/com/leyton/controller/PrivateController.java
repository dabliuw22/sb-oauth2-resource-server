
package com.leyton.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = {
            "/private"
        })
public class PrivateController {

    @GetMapping(
            value = {
                "/message"
            })
    public ResponseEntity<String> privateMessage() {
        return ResponseEntity.ok("Private message");
    }

    @PreAuthorize(
            value = "hasAnyRole('USER', 'ADMIN')")
    @GetMapping(
            value = {
                "/user"
            })
    public ResponseEntity<String> privateMessageUser(Principal principal) {
        return ResponseEntity.ok("Private message user: " + principal.getName());
    }

    @PreAuthorize(
            value = "hasRole('ADMIN')")
    @GetMapping(
            value = {
                "/admin"
            })
    public ResponseEntity<String> privateMessageAdmin(Principal principal) {
        return ResponseEntity.ok("Private message admin: " + principal.getName());
    }

    @PreAuthorize(
            value = "#oauth2.hasScope('read') and hasRole('USER')")
    @GetMapping(
            value = {
                "/read"
            })
    public ResponseEntity<String> privateMessageReadScope(Principal principal) {
        return ResponseEntity.ok("Private message read: " + principal.getName());
    }
}
