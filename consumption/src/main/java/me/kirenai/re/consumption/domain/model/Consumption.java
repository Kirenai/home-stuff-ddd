package me.kirenai.re.consumption.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumption {

    private String consumptionId;
    private Integer unit;
    private Integer percentage;
    private String nourishmentId;
    private String userId;

}
