package me.kirenai.re.category.domain.port.in;

import me.kirenai.re.category.domain.model.Category;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ListCategoriesPort {

    Flux<Category> findAll(Pageable pageable);

}
