package org.seuge.vetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Root controller
 * Created by Seuge on 30.10.2016.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Index page
     * @return page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

}
