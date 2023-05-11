package pl.waw.great.productms.service.mapper;

import org.springframework.stereotype.Component;
import pl.waw.great.productms.controller.dto.ContentDto;
import pl.waw.great.productms.controller.dto.ProductDto;
import pl.waw.great.productms.domain.Product;

@Component
public class ProductMapper {

    public ProductDto map(Product product){
        return ProductDto.builder()
                .ean(product.getEan())
                .name(product.getName())
                .content(ContentDto.builder()
                        .form(product.getContent().getForm())
                        .value(product.getContent().getValue())
                        .build())
                .expireDate(product.getExpireDate())
                .lot(product.getLot())
                .build();
    }
}
