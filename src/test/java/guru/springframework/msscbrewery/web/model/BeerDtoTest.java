package guru.springframework.msscbrewery.web.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BeerDtoTest {

    @Test
    void shouldCreateValidObject() {
        String name = "Famous";
        String type = "Pale Ale";
        Long upc = 100L;

        BeerDto beer = BeerDto.builder()
                .beerName("Famous")
                .beerType("Pale Ale").
                id(UUID.randomUUID()).
                upc(upc)
                .build();

        assertEquals(beer.getBeerName(), name);
        assertEquals(beer.getBeerType(), type);
        assertEquals(beer.getUpc(), upc);
        assertEquals(beer.getId().getClass(), UUID.class);
    }
}
