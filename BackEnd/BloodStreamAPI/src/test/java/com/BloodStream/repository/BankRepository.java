package com.BloodStream.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BankRepository {

  @Autowired
  private com.BloodStream.dao.BankRepository bankRepo;

  @Test
  void testFindAll() {
    bankRepo.findAll().forEach(System.out::println);
  }
}
