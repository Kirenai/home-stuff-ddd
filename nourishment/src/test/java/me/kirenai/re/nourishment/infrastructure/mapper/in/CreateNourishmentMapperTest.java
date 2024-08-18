package me.kirenai.re.nourishment.infrastructure.mapper.in;

import me.kirenai.re.nourishment.domain.model.NourishmentTypePercentage;
import me.kirenai.re.nourishment.domain.model.dto.CreateNourishmentTypePercentageRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static me.kirenai.re.nourishment.domain.enums.NourishmentTypeEnum.PERCENTAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateNourishmentMapperTest {
    private final CreateNourishmentMapper mapper = Mappers.getMapper(CreateNourishmentMapper.class);

    @Test
    void testMapInNourishmentTypePercentage() {
        CreateNourishmentTypePercentageRequest percentageRequest = CreateNourishmentTypePercentageRequest.builder().percentage(50).build();
        NourishmentTypePercentage nourishmentTypePercentage = this.mapper.mapInNourishmentTypePercentage(percentageRequest);

        assertNotNull(nourishmentTypePercentage);
        assertNotNull(nourishmentTypePercentage.nourishmentType());
        assertNotNull(nourishmentTypePercentage.percentage());

        assertEquals(0.5, nourishmentTypePercentage.percentage());
        assertEquals(PERCENTAGE, nourishmentTypePercentage.nourishmentType());
    }

}