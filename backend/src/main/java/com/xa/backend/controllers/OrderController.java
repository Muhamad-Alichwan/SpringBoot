package com.xa.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xa.backend.entities.OrderDetail;
import com.xa.backend.repositories.OrderDetailRepository;
import com.xa.backend.repositories.OrderHeaderRepository;
import com.xa.backend.repositories.VariantRepository;


@Controller
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private VariantRepository variantRepository;

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Autowired
  private OrderHeaderRepository orderHeaderRepository;

  @GetMapping("")
  public ModelAndView getOrder() {
      ModelAndView view = new ModelAndView("order/index");
      List<OrderDetail> orderDetails = orderDetailRepository.getAllOrderDetails();
      view.addObject("orderDetails", orderDetails);
      view.addObject("title", "Orders");
      return view;
  }
  
}
