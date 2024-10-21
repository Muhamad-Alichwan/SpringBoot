package com.xa.alichwan.services;

import java.util.List;

import com.xa.alichwan.entities.Variant;

public interface VariantService {
  List<Variant> getAllVariants();
  Variant saveVariant(Variant variant);
  Variant getVariantById(Long id);
  void deleteVariantById(Long id);
}
