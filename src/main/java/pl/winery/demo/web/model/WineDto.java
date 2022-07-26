package pl.winery.demo.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.UUID;

/**
 * Created by mz on 19.07.22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WineDto {

    @Null
    private UUID id;
    @NotBlank
    private String wineName;
    @NotBlank
    private String wineType;
}
