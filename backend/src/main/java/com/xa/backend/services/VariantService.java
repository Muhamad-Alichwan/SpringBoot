package com.xa.backend.services;

import java.util.List;

import com.xa.backend.entities.Variant;

public interface VariantService {
  List<Variant> getAllVariants();
  Variant saveVariant(Variant variant);
  Variant getVariantById(Long id);
  void deleteVariantById(Long id);
}
