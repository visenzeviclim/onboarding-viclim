package com.happy.service;

import com.happy.exception.PositiveIntegerException;
import com.happy.model.Product;
import com.happy.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Hung on 21/9/16.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.productService = new ProductServiceImpl(productRepository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test001_GetMilkQty() {
        int getMilkQty_Expected = 100;
        int getMilkQty_Actual;

        // Given
        assertNotNull(this.productRepository);
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(getMilkQty_Expected).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));
        getMilkQty_Actual = this.productService.getMilkQty();

        // Then
        assertEquals("Expected milk quantity matches Actual milk quantity.", getMilkQty_Expected, getMilkQty_Actual);
    }

    @Test
    public void test002_GetMilkQty_MultipleRows() {
        int totalAmtOfStores = 10;
        Map<Integer, Product> lProducts = new HashMap<>();
        int getMilkQty_Expected = 100;
        AtomicInteger getMilkQty_Actual = new AtomicInteger();

        // Given
        assertNotNull(this.productRepository);
        for(int i=1; i<=totalAmtOfStores; i++){
            lProducts.put(i, new Product.ProductBuilder(i).setMilkQty(getMilkQty_Expected).build());
        }

        // When
        lProducts.forEach((id, mockProd) -> {
            when(this.productRepository.findById(id)).thenReturn(Optional.of(mockProd));
            getMilkQty_Actual.set(this.productService.getMilkQty());
            assertEquals("Expected milk quantity matches Actual milk quantity.", getMilkQty_Expected, getMilkQty_Actual.get());
        });
    }

    @Test
    public void test003_GetEggsQty() {
        int getEggQty_Expected = 100;
        int getEggQty_Actual;

        // Given
        assertNotNull(this.productRepository);
        Product mockProd = new Product.ProductBuilder(1).setEggQty(getEggQty_Expected).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));
        getEggQty_Actual = this.productService.getEggsQty();

        // Then
        assertEquals("Expected egg quantity matches Actual egg quantity.", getEggQty_Expected, getEggQty_Actual);
    }

    @Test
    public void test004_BuyMilk() throws PositiveIntegerException {
        assertNotNull(this.productRepository);
        int milkQty = 10;

        // Given
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(milkQty).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));
        assertEquals(this.productService.buyMilk(1), 1 );

    }

    @Test
    public void test005_BuyMilk_ShouldSeeThatPurchasedMilk_Return_1(){
        assertNotNull(this.productRepository);
        int milkQty = 10;

        // Given
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(milkQty).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));
        assertEquals(this.productService.buyMilk(1), 1 );

    }

    @Test
    public void test006_BuyMilk_ShouldSeeThatPurchasedMilk_Return_Max() throws PositiveIntegerException {
        assertNotNull(this.productRepository);
        int milkQty = 10;
        int max_Available = milkQty;
        int purchasedAmt_Attempt = max_Available;

        // Given
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(max_Available).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));

        // Then
        assertEquals(purchasedAmt_Attempt, this.productService.buyMilk(purchasedAmt_Attempt));
    }

    @Test
    public void test007_BuyMilk_ShouldSeeThatPurchasedMilk_Return_Max() throws PositiveIntegerException {
        assertNotNull(this.productRepository);
        int milkQty = 10;
        int max_Available = milkQty;
        int purchasedAmt_Attempt = max_Available + 2;

        // Given
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(max_Available).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));

        // Then
        assertEquals(max_Available, this.productService.buyMilk(purchasedAmt_Attempt));
    }


    @Test
    public void test008_BuyEggs_ShouldSeeThatPurchasedEgg_Return_1(){
        assertNotNull(productRepository);
        int eggQty = 10;

        // Given
        Product mockProd = new Product.ProductBuilder(1).setEggQty(eggQty).build();

        // When
        when(productRepository.findById(1)).thenReturn(Optional.of(mockProd));

        // Then
        assertEquals( productService.buyEggs(1), 1 );

    }


    @Test
    public void test009_BuyEggs_ShouldSeeThatPurchasedMilk_Return_Max(){
        assertNotNull(this.productRepository);
        int eggQty = 10;
        int max_Available = eggQty;
        int purchasedAmt_Attempt = max_Available;

        // Given
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(max_Available).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));

        // Then
        assertEquals(purchasedAmt_Attempt, this.productService.buyMilk(purchasedAmt_Attempt));

    }

    @Test
    public void test010_BuyEggs_ShouldSeeThatPurchasedMilk_Return_Max(){
        assertNotNull(this.productRepository);
        int eggQty = 10;
        int max_Available = eggQty;
        int purchasedAmt_Attempt = max_Available + 2;

        // Given
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(max_Available).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));

        // Then
        assertEquals(max_Available, this.productService.buyMilk(purchasedAmt_Attempt));

    }

}