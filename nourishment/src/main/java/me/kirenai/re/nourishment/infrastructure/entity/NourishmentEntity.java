package me.kirenai.re.nourishment.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Nourishment
 *
 * @author Kirenai RE
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "nourishments")
public class NourishmentEntity {

    @Id
    private Long nourishmentId;
    private String name;
    private String imageUrl;
    private String description;
    private Boolean isAvailable;
    private Integer unit;
    private Integer percentage;
    private Long userId;
    private Long categoryId;
    private Long nourishmentTypeId;

}