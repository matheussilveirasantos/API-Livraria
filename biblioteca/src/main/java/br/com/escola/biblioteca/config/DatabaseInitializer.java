package br.com.escola.biblioteca.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "123456");
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM pg_database WHERE datname = 'biblioteca'");
            rs.next();
            if (rs.getInt(1) == 0) {
                stmt.executeUpdate("CREATE DATABASE biblioteca");
                System.out.println("Banco 'biblioteca' criado com sucesso!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao verificar/criar banco: " + e.getMessage());
        }
    }
}