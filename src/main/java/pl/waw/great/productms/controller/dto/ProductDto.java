package pl.waw.great.productms.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ProductDto {

    private String ean;

    private String name;
    private ContentDto content;

    private String lot;
    private LocalDate expireDate;
}
