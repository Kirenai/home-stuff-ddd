package me.kirenai.re.nourishment.domain.port.out.client;

import me.kirenai.re.nourishment.domain.model.dto.GetCategoryResponse;
import reactor.core.publisher.Mono;

public interface CategoryClientPort {

    Mono<GetCategoryResponse> getCategoryByCategoryId(Long categoryId);

}
