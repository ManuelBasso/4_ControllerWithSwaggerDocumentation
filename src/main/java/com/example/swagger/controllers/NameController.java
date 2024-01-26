package com.example.swagger.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
public class NameController {

    @Operation(summary = "get the param name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "correct name", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "invalid name", content = @Content),
            @ApiResponse(responseCode = "404", description = "name not found", content = @Content),
    })
    @GetMapping(path = "/getName")
    public String getName(@RequestParam String name) {
        return name;
    }


    @Operation(summary = "get the param name on reverse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "correct name", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "invalid name", content = @Content),
            @ApiResponse(responseCode = "404", description = "name not found", content = @Content),
    })
    @PostMapping(path = "/postName/{name}")
    public String postName(@PathVariable String name) {
        StringBuilder str = new StringBuilder(name);
        return str.reverse().toString();
    }
}
