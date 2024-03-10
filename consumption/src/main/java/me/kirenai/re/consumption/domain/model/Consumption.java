package me.kirenai.re.consumption.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumption {

    private Long consumptionId;
    private Integer unit;
    private Integer percentage;
    private Long nourishmentId;
    private Long userId;

}
