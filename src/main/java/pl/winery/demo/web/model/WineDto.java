package pl.winery.demo.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by mz on 19.07.22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WineDto {

    private UUID id;
    private String wineName;
    private String wineType;
}
