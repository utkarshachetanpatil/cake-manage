package com.glasgow.cakemanager.controller;

import com.glasgow.cakemanager.model.Cake;
import com.glasgow.cakemanager.service.CakeManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CakeManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CakeManagerController.class);

    private final CakeManagerService cakeManagerService;
    public CakeManagerController(final CakeManagerService cakeManagerService)
    {
        this.cakeManagerService = cakeManagerService;
    }

    @GetMapping(value = "/cake/name/{name}")
    public List<Cake> findCakeByName(@PathVariable String name)
    {
        LOGGER.info("Request received for " +name +" cake search ");
        return cakeManagerService.findCakeByName(name);

    }

    @GetMapping(value = "/cake/color/{color}")
    public List<Cake> findCakeByColor(@PathVariable String color)
    {
        LOGGER.info("Request received for " +color +" color cake search ");
        return cakeManagerService.findCakeByColor(color);

    }

    @GetMapping("/cake/id/{id}")
    private Cake getCakeById(@PathVariable("id") int id)
    {
        LOGGER.info("Request received for cake search for "+id );
        return cakeManagerService.getCakeById(id);
    }

    @PostMapping("/savecake")
    private int saveCake(@RequestBody Cake cake)
    {
        LOGGER.info("Request received for addition of new cake" +cake);
        cakeManagerService.saveCake(cake);
        return cake.getId();
    }

    @GetMapping("/cakelist")
    private List<Cake> getCakeList()
    {
        LOGGER.info("Request received to display Cake List ");
        return cakeManagerService.getCakeList();
    }
}
