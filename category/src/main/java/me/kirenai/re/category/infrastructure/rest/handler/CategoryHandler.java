package me.kirenai.re.category.infrastructure.rest.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.category.application.service.CategoryService;
import me.kirenai.re.category.domain.model.dto.CreateCategoryRequest;
import me.kirenai.re.category.domain.model.dto.ListCategoriesResponse;
import me.kirenai.re.category.domain.model.dto.UpdateCategoryRequest;
import me.kirenai.re.category.infrastructure.mapper.CategoryMapper;
import me.kirenai.re.validation.Validator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static me.kirenai.re.category.util.Constants.PATH_PARAM_CATEGORY_ID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryHandler {

    private final CategoryService categoryService;
    private final CategoryMapper mapper;
    private final Validator validator;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        log.info("Invoking CategoryHandler.findAll method");
        int page = Integer.parseInt(serverRequest.queryParam("page").orElse("0"));
        int size = Integer.parseInt(serverRequest.queryParam("size").orElse("6"));
        String[] sort = serverRequest.queryParam("sort").orElse("categoryId,ASC").split(",");
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort[1]), sort[0]));
        Flux<ListCategoriesResponse> response = this.categoryService.getCategories(pageable)
                .map(this.mapper::mapOutCategoryToListCategoriesResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListCategoriesResponse.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        log.info("Invoking CategoryHandler.findById method");
        String categoryId = request.pathVariable(PATH_PARAM_CATEGORY_ID);
        return this.categoryService.getCategoryById(Long.valueOf(categoryId))
                .map(this.mapper::mapOutCategoryToGetCategoryResponse)
                .flatMap(response -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        log.info("Invoking CategoryHandler.create method");
        return request.bodyToMono(CreateCategoryRequest.class)
                .doOnNext(this.validator::validate)
                .map(this.mapper::mapInCreateCategoryRequestToCategory)
                .flatMap(this.categoryService::createCategory)
                .map(this.mapper::mapOutCategoryToCreateCategoryResponse)
                .flatMap(response -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        log.info("Invoking CategoryHandler.update method");
        String categoryId = request.pathVariable(PATH_PARAM_CATEGORY_ID);
        return request.bodyToMono(UpdateCategoryRequest.class)
                .doOnNext(this.validator::validate)
                .map(this.mapper::mapInUpdateCategoryRequestToCategory)
                .flatMap(category -> this.categoryService.updateCategory(Long.valueOf(categoryId), category))
                .map(this.mapper::mapOutCategoryToUpdateCategoryResponse)
                .flatMap(response -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        log.info("Invoking CategoryHandler.delete method");
        String categoryId = request.pathVariable(PATH_PARAM_CATEGORY_ID);
        return this.categoryService.deleteCategory(Long.valueOf(categoryId))
                .then(Mono.defer(() -> ServerResponse.noContent().build()));
    }

}
