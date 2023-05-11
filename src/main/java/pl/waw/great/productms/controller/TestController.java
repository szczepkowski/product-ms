package pl.waw.great.productms.controller;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.waw.great.productms.domain.Content;
import pl.waw.great.productms.domain.Form;
import pl.waw.great.productms.domain.Product;
import pl.waw.great.productms.repository.ProductRepository;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@RestController
@Profile("test")
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private ProductRepository productRepository;

    @PostMapping
    public void generate(int number) {
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
