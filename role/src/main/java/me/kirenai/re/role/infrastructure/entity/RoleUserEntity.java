package me.kirenai.re.role.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "roles_users")
public class RoleUserEntity {

    private Long roleId;
    private Long userId;

    @Builder.Default
    private List<RoleEntity> roles = new ArrayList<>();

    public static Mono<RoleUserEntity> fromRows(List<Map<String, Object>> rows) {
        return Mono.just(RoleUserEntity.builder()
                .roles(rows.stream()
                        .map(RoleEntity::fromRow)
                        .filter(Objects::nonNull)
                        .toList())
                .build());
    }

}