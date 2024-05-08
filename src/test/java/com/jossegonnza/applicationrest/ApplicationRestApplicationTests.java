package com.jossegonnza.applicationrest;

import com.jossegonnza.applicationrest.controllers.MainRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationRestApplicationTests {

	//Injectar controlador
	//Definir atributo que se va a auto cargar
	//GIVEN cargamos el controlador
	@Autowired
	private MainRestController mainRestController;

	//Prueba sobre el controlador
	@Test
	public void miRestControllerLoads() throws Exception {

		//El controlador no es null, es decir carga correctamente
		assertNotNull(mainRestController);
		assertThat(mainRestController).isNotNull();
	}

	//Cargar el gestor
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnHello() throws Exception {

		//Realizar una petición
		this.mockMvc.perform(
				//Hacer petición GET indicando la ruta
				get("/hello"))
				//Imprimir por pantalla el resultado
				.andDo(print())
				//Comprobamos que el status es 200 OK
				.andExpect(status().isOk())
				//Comprobamos que el contenido es lo que esperabamos
				.andExpect(content().string(containsString("Hello")));
	}

}
