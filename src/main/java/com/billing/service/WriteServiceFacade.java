package com.billing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.billing.domain.BillFormat;
import com.billing.domain.ItemizedBill;
import com.billing.exception.UnSupportedBillFormatException;

/*
 *  A Facade which would expose methods specific to
 *   file type and hide the write complexities.
 */
@Service
public class WriteServiceFacade {

  Logger log = LoggerFactory.getLogger(WriteServiceFacade.class);
  @Autowired
  @Qualifier("textWriteService")
  WriteService textWriteService;
  @Autowired
  @Qualifier("htmlWriteService")
  WriteService htmlWriteService;

  public void writeText(ItemizedBill bill, String path) {
    log.info("TEXT");
    this.textWriteService.writeBill(bill, path);
  }

  public void writeHTML(ItemizedBill bill, String path) {
    log.info("HTML");
    this.htmlWriteService.writeBill(bill, path);
  }

  public void writeBill(ItemizedBill bill, String format, String path) {
    if (BillFormat.TEXT.getFormat().equals(format))
      writeText(bill, path);
    else if (BillFormat.HTML.getFormat().equals(format))
      writeHTML(bill, path);
    else {
      log.error("UNSUPPORTED FORMAT");
      throw new UnSupportedBillFormatException("The mentioned format is not supported");
    }
  }

}
