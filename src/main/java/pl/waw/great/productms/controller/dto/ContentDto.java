package pl.waw.great.productms.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.waw.great.productms.domain.Form;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ContentDto {

    private Form form;
    private int value;
}
