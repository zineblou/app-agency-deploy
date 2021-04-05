package ma.atos.agencymanagement.controller;


import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.repository.HabilitationRepository;

import ma.atos.agencymanagement.service.HabilitationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
@RunWith(MockitoJUnitRunner.class)
public class HabilitationTests {

    @InjectMocks
    Habilitation habilitation;
    @Mock
    HabilitationService service;
    @Autowired
    private HabilitationController controler;

    @MockBean
    private HabilitationRepository repor;

    @Test
    public void contextLoads() {

       // Assertions.assertThat(( controler).isnotNull();


    }





}



