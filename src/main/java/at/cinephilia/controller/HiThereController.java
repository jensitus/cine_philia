package at.cinephilia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jens on 23.07.14.
 */

@Controller
@RequestMapping("/")
public class HiThereController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap modelMap) {
        modelMap.addAttribute("title", "Hi there, you shitty world!");
        return "main";
    }

}
