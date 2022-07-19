package pl.winery.demo.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping({"/{wineId}"})
    public ResponseEntity<WineDto> getWine(@PathVariable UUID wineId){
        return new ResponseEntity<>(wineService.getWineById(wineId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody WineDto wineDto){
        WineDto saveDto = wineService.saveNewWine(wineDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/wine" + saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{wineId}"})
    public ResponseEntity handleUpdate(@PathVariable("wineId") UUID wineId, @RequestBody WineDto wineDto){
        wineService.updateWine(wineId, wineDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{wineId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("wineId") UUID wineId){
        wineService.deleteWineById(wineId);
    }
}
