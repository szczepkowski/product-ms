package pl.waw.great.productms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity(name = "Product")
public class Product {

    @Id
    private String ean;

    private String name;
    @Embedded
    private Content content;

    private String lot;
    private LocalDate expireDate;
}