package com.xa.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.backend.entities.Category;
import com.xa.backend.repositories.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    
    @GetMapping("")
    public ModelAndView getCategory() {
        ModelAndView view = new ModelAndView("category/index");
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        view.addObject("title", "Category");
        return view;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("category/form");
        Category category = new Category();
        view.addObject("category", category);
        return view;
    }
    
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Category category, BindingResult result) {
        if (!result.hasErrors()) {
            categoryRepository.save(category);
        }
        return new ModelAndView("redirect:/category");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("category/form");
        Category category = categoryRepository.findById(id).orElse(null);
        view.addObject("category", category);
        return view;
    }

    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("category/deleteForm");
        Category category = categoryRepository.findById(id).orElse(null);
        view.addObject("category", category);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return new ModelAndView("redirect:/category");
    }
}