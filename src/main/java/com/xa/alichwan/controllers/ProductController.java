package com.xa.alichwan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xa.alichwan.entities.Category;
import com.xa.alichwan.entities.Product;
import com.xa.alichwan.repositories.CategoryRepository;
import com.xa.alichwan.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/product")
public class ProductController {

  // best pratice autowired is private the field(variabel untuk sebuah class)
  @Autowired
  private ProductRepository productRepository;
  
  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping("")
  public ModelAndView getProduct() {
      ModelAndView view = new ModelAndView("product/index");
      List<Product> products = productRepository.findAll();
      view.addObject("products", products);
      view.addObject("title", "Products");
      return view;
  }

  @GetMapping("/form")
  public ModelAndView form() {
    ModelAndView view = new ModelAndView("product/form");
    List<Category> categories = categoryRepository.findAll();
    view.addObject("categories", categories);
    Product product = new Product();
    view.addObject("product", product);
    return view;
  }

  @PostMapping("/save")
  public ModelAndView save(@ModelAttribute Product product, BindingResult result) {
      if (!result.hasErrors()) {
        productRepository.save(product);
      }
      return new ModelAndView("redirect:/product");
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable Long id) {
      ModelAndView view = new ModelAndView("product/form");
      List<Category> categories = categoryRepository.findAll();
      view.addObject("categories", categories);
      Product product = productRepository.findById(id).orElse(null);
      view.addObject("product", product);
      return view;
  }

  @GetMapping("/deleteForm/{id}")
  public ModelAndView deleteForm(@PathVariable Long id) {
      ModelAndView view = new ModelAndView("product/deleteForm");
      Product product = productRepository.findById(id).orElse(null);
      view.addObject("product", product);
      return view;
  }

  @GetMapping("/delete/{id}")
  public ModelAndView deleteProduct(@PathVariable("id") Long id) {
      productRepository.deleteById(id);
      return new ModelAndView("redirect:/product");
  }
}
