package pl.waw.great.productms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.waw.great.productms.controller.dto.ProductDto;
import pl.waw.great.productms.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> findAll(){
        return productService.getAll();
    }

    @GetMapping(value = "/{ean}")
    public ProductDto findByEan(@PathVariable String ean){
        return productService.findByEan(ean);
    }
}
