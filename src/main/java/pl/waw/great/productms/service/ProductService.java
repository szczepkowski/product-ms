package pl.waw.great.productms.service;

import org.springframework.stereotype.Service;
import pl.waw.great.productms.controller.dto.ProductDto;
import pl.waw.great.productms.repository.ProductRepository;
import pl.waw.great.productms.service.mapper.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
    }

    public ProductDto findByEan(String ean){
        if( ean == null){
            return null;
        }
        return productMapper.map(productRepository.findById(ean).orElseThrow(()-> new IllegalArgumentException("Product not exist with ean "+ean)));
    }
}
