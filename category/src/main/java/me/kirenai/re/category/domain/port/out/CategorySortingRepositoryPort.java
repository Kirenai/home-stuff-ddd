package me.kirenai.re.category.domain.port.out;

import me.kirenai.re.category.domain.model.Category;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface CategorySortingRepositoryPort {

    Flux<Category> findAll(Pageable pageable);

}
