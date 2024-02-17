package me.kirenai.re.nourishment.domain.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListNourishmentsResponse {

    private Long nourishmentId;
    private String name;
    private String imageUrl;
    private String description;
    private Boolean isAvailable;
    private ListNourishmentsTypeResponse type;

}
