package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController // Handle RESt requests
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource; // to pick up the message from the messages-properties file from resources
    //GET
    //URI - /hello-world
    //method - "Hello World"
    //@RequestMapping(method= RequestMethod.GET, path = "/hello-world") -> equals @GetMapping
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // Creating URI
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    // Creating URI
    //hello-world/path-variable/in28minutes
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name)); // sign %s will be replaced by, -> path variable name
    }


    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(
            //@RequestHeader(name = "Accept-Language", required = false)Locale locale
            ){
        return messageSource
                .getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
