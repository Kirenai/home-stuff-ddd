package me.kirenai.re.category.domain.model;

import lombok.*;

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
public class Category {

    private Long categoryId;
    private String name;

}