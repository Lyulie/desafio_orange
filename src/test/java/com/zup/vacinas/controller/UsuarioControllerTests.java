package com.zup.vacinas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zup.vacinas.dto.UsuarioDTORequest;
import com.zup.vacinas.dto.UsuarioDTOResponse;
import com.zup.vacinas.model.Usuario;
import com.zup.vacinas.sample.UsuarioSample;
import com.zup.vacinas.service.UsuarioService;

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
    UsuarioController.class,
    UsuarioService.class
})
@DisplayName("Valida api de usuario")
public class UsuarioControllerTests {

    public static final String USUARIO_URI = "/usuarios"; 
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    private Usuario usuario = UsuarioSample.gerarUsuario();
    private UsuarioDTORequest dtoRequest = UsuarioSample.gerarUsuarioDTORequest();
    private UsuarioDTOResponse dtoResponse = UsuarioSample.gerarUsuarioDTOResponse();

    @Test
    void criarUsuario() throws Exception {
        
        BDDMockito.given(usuarioService.criar(
            Mockito.any(Usuario.class)
        )).willReturn(usuario);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        String json = mapper.writeValueAsString(dtoRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .post(USUARIO_URI)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .characterEncoding("utf-8")
            .content(json);
        
        mockMvc.perform(request)
            .andExpect(status().isCreated())
            .andExpect(jsonPath("nome").value(dtoResponse.getNome()))
            .andExpect(jsonPath("email").value(dtoResponse.getEmail()));
    }
}
