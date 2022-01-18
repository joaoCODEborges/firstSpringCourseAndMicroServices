package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //Here, I want field1, field2 (dynamic filter)
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
       SomeBean someBean = new SomeBean("value1", "value2", "value3");
        //Here, I want field1, field2 (dynamic filter) we have to create the filters and config them.

        //CREATE DN filter
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1", "filed2");

        //Config DN filter
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        //Mapp DN filter
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

       return mapping;


    }

    //Here, I want field2, field3 (dynamic filter)
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBeans() {

        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));

        //Here, I want field, field2 (dynamic filter) we have to create the filters and config them.

        //CREATE
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed2", "filed3");
        //Config
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        //Mapp
        MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
        mapping.setFilters(filters);

        return mapping;
    }

    /*
    MappingJacksonValue createConfigureAndMapADynamicFilterToRetrieveAList(List<SomeBean> someBeanList) {
        //CREATE
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed2", "filed3");
        //Config
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        //Mapp
        MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
        mapping.setFilters(filters);

        return mapping;
    } */

}
