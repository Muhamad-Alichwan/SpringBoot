package com.xa.alichwan.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xa.alichwan.entities.Category;
import com.xa.alichwan.entities.Product;
import com.xa.alichwan.entities.Variant;
import com.xa.alichwan.repositories.CategoryRepository;
import com.xa.alichwan.repositories.ProductRepository;
import com.xa.alichwan.repositories.VariantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/variant")
public class VariantController {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private VariantRepository variantRepository;

  @GetMapping("")
  public ModelAndView getVariant() {
    ModelAndView view = new ModelAndView("variant/index");
    List<Variant> variants = variantRepository.findAll();
    view.addObject("variants", variants);
    view.addObject("title", "Variants");
    return view;
  }

  
  @GetMapping("/form")
  public ModelAndView form() {
    ModelAndView view = new ModelAndView("variant/form");
    List<Category> categories = categoryRepository.findAll();
    view.addObject("categories", categories);
    List<Product> products = productRepository.findAll();
    view.addObject("products", products);
    Variant variant = new Variant();
    view.addObject("variant", variant);
    return view;
}

  @PostMapping("/save")
  public ModelAndView save(@ModelAttribute Variant variant, BindingResult result) {
    if (!result.hasErrors()) {
        variantRepository.save(variant);
    }
    return new ModelAndView("redirect:/variant");
}
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("variant/form");
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        List<Product> products = productRepository.findAll();
        view.addObject("products", products);
        Variant variant = variantRepository.findById(id).orElse(null);
        view.addObject("variant", variant);
        return view;
    }
    
    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("variant/deleteForm");
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        List<Product> products = productRepository.findAll();
        view.addObject("products", products);
        Variant variant = variantRepository.findById(id).orElse(null);
        view.addObject("variant", variant);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteVariant(@PathVariable("id") Long id) {
        variantRepository.deleteById(id);
        return new ModelAndView("redirect:/variant");
    }
    
    
}
