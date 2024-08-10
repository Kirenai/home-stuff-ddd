package me.kirenai.re.nourishment.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetNourishmentResponse {

    private String nourishmentId;
    private String name;
    private String imageUrl;
    private String description;
    private Boolean isAvailable;
    private GetNourishmentTypeResponse type;

}
