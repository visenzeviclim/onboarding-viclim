package com.happy.controller;

import com.happy.exception.PositiveIntegerException;
import com.happy.model.EggsQtyResult;
import com.happy.model.ErrorRestResult;
import com.happy.model.HusbandShopResult;
import com.happy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/husband")
public class HusbandController {
    private ProductService productService;

    @Autowired
    public HusbandController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping( value = "/shop", method = RequestMethod.POST )
    public HusbandShopResult shop(){
        return new HusbandShopResult(1, 12);
    }

}
