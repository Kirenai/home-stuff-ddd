package me.kirenai.re.category.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Categories
 *
 * @author Kirenai
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "categories")
public class CategoryEntity {

    @Id
    private Long categoryId;
    private String name;

}