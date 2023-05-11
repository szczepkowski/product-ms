package pl.waw.great.productms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.waw.great.productms.domain.Content;
import pl.waw.great.productms.domain.Form;
import pl.waw.great.productms.domain.Product;
import pl.waw.great.productms.repository.ProductRepository;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class ProductIT {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void generate() {
        var number = 100;
        IntStream.range(0, number).forEach(i -> {
            Random rnd = new Random();
            int n = 10000000 + rnd.nextInt(90000000);
            Product product = Product.builder()
                    .ean(String.valueOf(n))
                    .name("TEST" + i)
                    .lot("120625/PLE1128 " + i)
                    .expireDate(LocalDate.now().plusYears(i))
                    .content(Content.builder()
                            .form(Form.values()[rnd.nextInt(4)])
                            .value(i)
                            .build())
                    .build();
            productRepository.save(product);
        });

    }
}
