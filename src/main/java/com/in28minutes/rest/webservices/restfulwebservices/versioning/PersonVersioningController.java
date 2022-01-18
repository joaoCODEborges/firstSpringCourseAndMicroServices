package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    // Mapping different URI (resources) Versioning (one type, but there are more types of versioning)

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Other options of Versioning
    // this is with "requesparameter", params = "" , does it serve to distinguish

    @GetMapping(value = "/person/param", params = "version=1") // POSTMAN - localhost:8080/person/param?version=1
    public PersonV1 paramV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/param", params = "version=2") // // POSTMAN - localhost:8080/person/param?version=2
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Another option to use Versioning its called: Header Versioning, with Header parameter
    // Not URI Polluting
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1") // POSTMAN.HEADERS = Key = Headers + Value = ...
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2") // POSTMAN.HEADERS = Key = Headers + Value = ...
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Other version is called by using Producers or Content Negotiation or Accept Versioning
    // Not URI Polluting
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json") // POSTMAN.HEADERS-ACCEPT + value produces
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json") // POSTMAN.HEADERS-ACCEPT + value produces
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


}
