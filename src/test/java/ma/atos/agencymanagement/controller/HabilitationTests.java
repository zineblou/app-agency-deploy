package ma.atos.agencymanagement.controller;


import ma.atos.agencymanagement.repository.HabilitationRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HabilitationTests {

    @Autowired
    private HabilitationController controler;

    @MockBean
    private HabilitationRepository repor;

    @Test
    public void contextLoads() {

       // Assertions.assertThat(( controler).isnotNull();


    }





}



