package me.kirenai.re.category.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Categories
 *
 * @author Kirenai
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "categories")
public class CategoryEntity {

    @Id
    private String categoryId;
    private String name;

}