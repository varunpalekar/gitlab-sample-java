package com.billing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.billing.domain.ItemCategoryMaster;
@Repository
public interface ItemCategoryMasterRepository extends MongoRepository<ItemCategoryMaster, String> {
  public ItemCategoryMaster findByMasterName(String masterName);
}
