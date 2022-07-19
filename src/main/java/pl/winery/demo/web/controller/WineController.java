package pl.winery.demo.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.winery.demo.web.model.WineDto;
import pl.winery.demo.web.services.WineService;

import java.util.UUID;

/**
 * Created by mz on 19.07.22
 */
@RequestMapping("api/v1/wine")
@RestController
public class WineController {

    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<WineDto> getWine(@PathVariable UUID wineId){
        return new ResponseEntity<>(wineService.getWineById(wineId), HttpStatus.OK);
    }
}
