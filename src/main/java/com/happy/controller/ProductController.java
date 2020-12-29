package com.happy.controller;


import com.happy.exception.PositiveIntegerException;
import com.happy.model.*;
import com.happy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/store")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path="/hasmilk", method = RequestMethod.GET)
    public MilkQtyResult getMilkQty(){
        return new MilkQtyResult(productService.getMilkQty() );
    }

    @RequestMapping(path="/haseggs", method = RequestMethod.GET)
    public EggsQtyResult getEggsQty(){
        return new EggsQtyResult(productService.getEggsQty());
    }

    @RequestMapping( value = "/buymilk", method = RequestMethod.POST )
    public MilkQtyResult buyMilk(@RequestParam int quantity){

        int purchasedQty = productService.buyMilk(quantity );
        return new MilkQtyResult(purchasedQty);
    }

    @RequestMapping( value = "/buyeggs", method = RequestMethod.POST )
    public EggsQtyResult buyEggs(@RequestParam int quantity){
        int purchasedQty = productService.buyEggs(quantity );
        return new EggsQtyResult(purchasedQty);
    }

    @ExceptionHandler(PositiveIntegerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorRestResult handlePostiveIntegerException(PositiveIntegerException pe ) {

        return new ErrorRestResult(101, "Parameter must be a positive integer.");

    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorRestResult handleInvalidInputException(org.springframework.http.converter.HttpMessageNotReadableException invalidEx ) {
        return new ErrorRestResult(101, "Parameter must be a positive integer.");
    }

    @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorRestResult handleInvalidInputException(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException invalidEx ) {
        return new ErrorRestResult(101, "Parameter must be a positive integer.");
    }



}
