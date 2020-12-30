package com.happy.exception;

import com.happy.model.Product;
import com.happy.repository.ProductRepository;
import com.happy.service.ProductServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class PositiveIntegerTest {

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

    @Test(expected = PositiveIntegerException.class)
    public void exceptiontest001_zero_BuyEggs() {
        int getEggQty_Expected = 0;
        int getEggQty_Actual;

        // Given
        assertNotNull(this.productRepository);
        Product mockProd = new Product.ProductBuilder(1).setEggQty(getEggQty_Expected).build();

        // When
        when(this.productRepository.findById(1)).thenReturn(Optional.of(mockProd));
        getEggQty_Actual = this.productService.getEggsQty();

        // Then :  @Expected will take care of capturing the exception generated from this.productService.buyEggs
        assertEquals("Expected zero egg quantity matches Actual zero egg quantity.", getEggQty_Expected, getEggQty_Actual);
        this.productService.buyEggs(getEggQty_Expected);
    }

    @Test(expected = PositiveIntegerException.class)
    public void exceptiontest002_zero_BuyMilk() {
        int getMilkQty_Expected = 0;
        int getMilkQty_Actual;

        // Given
        assertNotNull(this.productRepository);
        Product mockProd = new Product.ProductBuilder(1).setMilkQty(getMilkQty_Expected).build();

        // When
        when(productRepository.findById(1)).thenReturn(Optional.of(mockProd));
        getMilkQty_Actual = this.productService.getMilkQty();

        // Then :  @Expected will take care of capturing the exception generated from this.productService.buyMilk
        assertEquals("Expected zero milk quantity matches Actual zero milk quantity.", getMilkQty_Expected, getMilkQty_Actual);
        this.productService.buyMilk(getMilkQty_Expected);
    }
}
