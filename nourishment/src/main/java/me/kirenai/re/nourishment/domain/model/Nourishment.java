package me.kirenai.re.nourishment.domain.model;

import lombok.*;

/**
 * Nourishment
 *
 * @author Kirenai RE
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Nourishment {

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