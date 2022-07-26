package pl.winery.demo.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.winery.demo.web.model.WineDto;
import pl.winery.demo.web.services.WineService;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(WineController.class)
public class WineControllerTest {

    @MockBean
    WineService wineService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    WineDto validWine;

    @Before
    public void setUp(){
        validWine = WineDto.builder().id(UUID.randomUUID())
                .wineName("Wine1")
                .wineType("Dry")
                .build();
    }

    @Test
    public void getWine() throws Exception {
        given(wineService.getWineById(any(UUID.class))).willReturn(validWine);
        mockMvc.perform(get("/api/v1/wine/" + validWine.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id", is(validWine.getId().toString())))
                .andExpect(jsonPath("$.wineName", is("Wine1")));
    }

    @Test
    public void handlePost() throws Exception {
        WineDto wineDto = validWine;
        wineDto.setId(null);
        WineDto savedDto = WineDto.builder().id(UUID.randomUUID()).wineName("New Wine").build();
        String wineDtoJson = objectMapper.writeValueAsString(wineDto);

        given(wineService.saveNewWine(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/wine/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wineDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void handleUpdate() throws Exception {
        WineDto wineDto = validWine;
        wineDto.setId(null);
        String beerDtoJson = objectMapper.writeValueAsString(wineDto);

        //when
        mockMvc.perform(put("/api/v1/wine/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isNoContent());

        then(wineService).should().updateWine(any(), any());
    }

}