package at.cinephilia.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * User: fkleedorfer
 * Date: 07.09.14
 */
@Controller
@RequestMapping(value = "/ng")
public class AngularController
{
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public ModelAndView index() throws IOException {
    ModelAndView modelAndView = new ModelAndView("index");
    return modelAndView;
  }

}
