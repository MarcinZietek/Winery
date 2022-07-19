package pl.winery.demo.web.services;

import pl.winery.demo.web.model.WineDto;

import java.util.UUID;

/**
 * Created by mz on 19.07.22
 */
public interface WineService {
    WineDto getWineById(UUID wineId);
    WineDto saveNewWine(WineDto wineDto);
    void updateWine(UUID wineId, WineDto wineDto);
    void deleteWineById(UUID wineId);
}
