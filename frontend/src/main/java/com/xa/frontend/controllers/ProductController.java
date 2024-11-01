package com.xa.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
  @GetMapping("")
  public ModelAndView product() {
      ModelAndView view = new ModelAndView("product/index");
      view.addObject("title", "Product Page");
      return view;
  }

  @GetMapping("/form")
  public ModelAndView form() {
      ModelAndView view = new ModelAndView("product/form");
      return view;
  }
}
