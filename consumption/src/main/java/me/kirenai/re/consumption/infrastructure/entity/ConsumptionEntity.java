package me.kirenai.re.consumption.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "consumptions")
public class ConsumptionEntity {

    @Id
    private String consumptionId;
    private Integer unit;
    private Double percentage;
    private String nourishmentId;
    private String userId;

}
