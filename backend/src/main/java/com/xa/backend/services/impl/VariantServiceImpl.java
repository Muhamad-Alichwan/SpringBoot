package com.xa.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.backend.entities.Variant;
import com.xa.backend.repositories.VariantRepository;
import com.xa.backend.services.VariantService;

@Service
public class VariantServiceImpl implements VariantService {
  @Autowired
  private VariantRepository variantRepository;

  @Override
  public List<Variant> getAllVariants() {
    return variantRepository.getAllVariants();
  }

  @Override
  public Variant saveVariant(Variant variant) {
    return variantRepository.save(variant);
  }

  @Override
  public Variant getVariantById(Long id) {
    return variantRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteVariantById(Long id) {
    Variant variant = variantRepository.findById(id).orElse(null);
    variantRepository.delete(variant);
  }

  @Override
  public List<Variant> getVariantsByProductId(Long productId) {
    return variantRepository.getVariantsByProductId(productId);
  }

}
