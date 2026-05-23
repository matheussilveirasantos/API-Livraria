package br.com.escola.biblioteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${biblioteca.openapi.dev-url}")
    private String devUrl;

    @Value("${biblioteca.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI customOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Servidor de Desenvolvimento");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Servidor de Produção");

        Contact contact = new Contact();
        contact.setName("Matheus Silveira Santos");
        contact.setUrl("https://github.com/matheussilveirasantos/API-Livraria");

        License license = new License()
                .name("Apache License 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
                .title("API de Catálogo de Livros e Autores")
                .version("1.0.0")
                .description("API REST para gerenciamento de uma biblioteca simples, " +
                             "permitindo o cadastro de autores e livros com relacionamento entre entidades.")
                .termsOfService("https://github.com/matheussilveirasantos/API-Livraria")
                .contact(contact)
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer))
                .tags(List.of(
                        new Tag().name("Autores")
                                 .description("Operações de CRUD para gerenciamento de autores"),
                        new Tag().name("Livros")
                                 .description("Operações de CRUD para gerenciamento de livros")
                ));
    }
}