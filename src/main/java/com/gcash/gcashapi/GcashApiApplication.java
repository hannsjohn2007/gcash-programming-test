package com.gcash.gcashapi;

import com.gcash.controller.DeliveryCostController;
import com.gcash.controller.VoucherController;
import com.gcash.model.DeliveryCostInfo;
import com.gcash.model.ParcelInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class GcashApiApplication {

    @Value("${voucher.baseURI}")
    private String baseURI;
    @Value("${voucher.apikey}")
    private String apikey;

    public static void main(String[] args) {
        SpringApplication.run(GcashApiApplication.class, args);
    }

    @PostMapping ("/computeDeliveryCost")
    @ResponseBody
    public DeliveryCostInfo computeDeliveryCost(@RequestBody ParcelInfo parcel) {
        DeliveryCostController costCtrl = new DeliveryCostController();
        Logger logger = LoggerFactory.getLogger(GcashApiApplication.class);
        logger.info(String.format("%s", parcel));
        return costCtrl.computeDeliveryCost(parcel);
    }

    @PostMapping (value = "/computeDeliveryCost", params = "voucher")
    @ResponseBody
    public DeliveryCostInfo computeDeliveryCostWithVoucher(@RequestParam String voucher, @RequestBody ParcelInfo parcel) {
        DeliveryCostController costCtrl = new DeliveryCostController();
        VoucherController voucherCtrl = new VoucherController(baseURI, apikey);
        Logger logger = LoggerFactory.getLogger(GcashApiApplication.class);
        DeliveryCostInfo costInfo = costCtrl.computeDeliveryCost(parcel);
        logger.info(String.format("%s with voucher %s", parcel, voucher));

        if (costInfo.isRejected()) {
            return costInfo;
        }

        return voucherCtrl.applyVoucher(costInfo, voucher);
    }
}
