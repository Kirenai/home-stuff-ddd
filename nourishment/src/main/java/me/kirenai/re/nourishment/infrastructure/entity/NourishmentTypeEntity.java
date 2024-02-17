package me.kirenai.re.nourishment.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Table("nourishment_type")
public class NourishmentTypeEntity {

    @Id
    private Long nourishmentTypeId;
    private String name;

}
