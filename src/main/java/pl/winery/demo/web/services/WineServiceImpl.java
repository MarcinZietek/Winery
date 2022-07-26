package pl.winery.demo.web.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.winery.demo.web.model.WineDto;

import java.util.UUID;

/**
 * Created by mz on 19.07.22
 */
@Slf4j
@Service
public class WineServiceImpl implements WineService {
    @Override
    public WineDto getWineById(UUID wineId) {
        return WineDto.builder().id(UUID.randomUUID())
                .wineName("Bordeaux")
                .wineType("Dry")
                .build();
    }

    @Override
    public WineDto saveNewWine(WineDto wineDto) {
        return wineDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateWine(UUID wineId, WineDto wineDto) {

    }

    @Override
    public void deleteWineById(UUID wineId) {
        log.debug("Deleting a wine...");
    }
}
