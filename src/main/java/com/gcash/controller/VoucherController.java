package com.gcash.controller;

import com.gcash.model.DeliveryCostInfo;
import com.gcash.model.VoucherInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Date;

public class VoucherController {
    private final Logger logger = LoggerFactory.getLogger(VoucherController.class);

    private final String baseURI;
    private final String apikey;


    public VoucherController(String baseURI, String apikey) {
        this.baseURI = baseURI;
        this.apikey = apikey;
    }

    public DeliveryCostInfo applyVoucher(DeliveryCostInfo costInfo, String voucher) {
        VoucherInfo voucherInfo = getVoucherInformation(voucher);
        Date date = new Date();
        if (voucherInfo.getExpiry().before(date)) {
            costInfo.setMessage(String.format("Voucher %s is expired", voucher));
        } else {
            double discounted = costInfo.getCost() * convertDiscountToPercentage(voucherInfo.getDiscount());
            costInfo.setCost(discounted);
            costInfo.setMessage(String.format("%f Discount from voucher %s is applied", discounted, voucher));
        }
        return costInfo;
    }

    private double convertDiscountToPercentage(double discount) {
        return discount / 100;
    }

    private VoucherInfo getVoucherInformation(String voucher) throws HttpClientErrorException {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        UriComponents uri = UriComponentsBuilder.fromUriString(baseURI)
                .path(voucher)
                .queryParam("key", apikey)
                .build();
        logger.debug(String.format("Get voucher [%s] info", voucher));
        ResponseEntity<VoucherInfo> result = rest.exchange(uri.toUriString(), HttpMethod.GET, entity, VoucherInfo.class);


        if (result.getStatusCode() == HttpStatus.OK) {
            return result.getBody();
        } else {
            throw new HttpClientErrorException(result.getStatusCode());
        }
    }

}
