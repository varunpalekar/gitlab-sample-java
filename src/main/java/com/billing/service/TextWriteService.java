package com.billing.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.billing.domain.ItemizedBill;
import com.billing.exception.FileWriteException;

@Service
public class TextWriteService implements WriteService {
  
  Logger log =  LoggerFactory.getLogger(TextWriteService.class);
  

  @Override
  public void writeBill(ItemizedBill bill, String path) {
    log.info("Generating bill at path : "+path);
    try (OutputStream os = new FileOutputStream(new File(path))) {
      os.write(bill.toString().getBytes(), 0, bill.toString().length());
      log.info("The bill is generated!");
    } catch (FileNotFoundException e) {
      throw new FileWriteException(e.getMessage());
    } catch (IOException e) {
      throw new FileWriteException(e.getMessage());
    }
  }

}
