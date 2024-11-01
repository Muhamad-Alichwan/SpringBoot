package com.xa.backend.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.xa.backend.entities.Category;
import com.xa.backend.entities.Product;
import com.xa.backend.entities.Variant;
import com.xa.backend.repositories.CategoryRepository;
import com.xa.backend.repositories.ProductRepository;
import com.xa.backend.repositories.VariantRepository;
import com.xa.backend.services.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping("/variant")
public class VariantController {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private VariantRepository variantRepository;

  @Autowired
  private ProductService productService;

  @GetMapping("")
  public ModelAndView getVariant() {
    ModelAndView view = new ModelAndView("variant/index");
    List<Variant> variants = variantRepository.findAll();
    view.addObject("variants", variants);
    view.addObject("title", "Variants");
    return view;
  }

  @GetMapping("/products-by-category/{categoryId}")
  @ResponseBody
  public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
    return productService.getProductsByCategoryId(categoryId);
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
