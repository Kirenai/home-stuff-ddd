package me.kirenai.re.consumption.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Consumption
 *
 * @author Kirenai
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "consumptions")
public class ConsumptionEntity {

    @Id
    private Long consumptionId;
    private Integer unit;
    private Integer percentage;
    private Long nourishmentId;
    private Long userId;

}
