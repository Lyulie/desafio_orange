package com.zup.vacinas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zup.vacinas.dto.VacinaDTORequest;
import com.zup.vacinas.dto.VacinaDTOResponse;
import com.zup.vacinas.model.Usuario;
import com.zup.vacinas.model.Vacina;
import com.zup.vacinas.sample.UsuarioSample;
import com.zup.vacinas.sample.VacinaSample;
import com.zup.vacinas.service.UsuarioService;
import com.zup.vacinas.service.VacinaService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {
   VacinaController.class,
   VacinaService.class,
   UsuarioService.class
})
@DisplayName("Valida api da vacinação")
public class VacinaControllerTests {

    private static final String VACINA_URI = "/vacinas";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacinaService vacinaService;

    @MockBean
    private UsuarioService usuarioService;

    private Vacina vacina = VacinaSample.gerarVacina();
    private VacinaDTORequest dtoRequest = VacinaSample.gerarVacinaDTORequest();
    private VacinaDTOResponse dtoResponse = VacinaSample.gerarVacinaDTOResponse();

    private Usuario usuario = UsuarioSample.gerarUsuario();

    @Test
    @DisplayName("Nova vacinação")
    void cadastrarNovaVacina() throws Exception {

        BDDMockito.given(usuarioService.buscarPorId(
            Mockito.anyInt()
        )).willReturn(usuario);
        
        BDDMockito.given(vacinaService.criar(
            Mockito.any(Vacina.class)
        )).willReturn(vacina);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        String json = mapper.writeValueAsString(dtoRequest);
        
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .post(VACINA_URI)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .characterEncoding("utf-8")
            .content(json);
        
        mockMvc.perform(request)
            .andExpect(status().isCreated())
            .andExpect(jsonPath("nomeUsuario").value(dtoResponse.getNomeUsuario()))
            .andExpect(jsonPath("email").value(dtoResponse.getEmail()))
            .andExpect(jsonPath("nome").value(dtoResponse.getNome()))
            .andExpect(jsonPath("dataDaAplicacao").isNotEmpty());
    }
}
