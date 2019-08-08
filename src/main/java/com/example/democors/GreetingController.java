package com.example.democors;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @CrossOrigin(origins = "http://localhost:82")
    @GetMapping("/")
    public String greeting() {
        return "Hello, Quang";
    }

    @GetMapping("/helloCallback")
    public void greetingCallback(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "callback") String callback)
                    throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/javascript");
        out.print(callback + "('Hello, callback');");

    }
}
