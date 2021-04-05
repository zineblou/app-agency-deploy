package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.repository.AgencyRepository;
import ma.atos.agencymanagement.repository.ManagerRepository;
import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgencyControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    ManagerRepository managerRepository;

    @Test
    public void getAgencyList() throws Exception{
        String uri = "/agencies";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Agency[] agencies = super.mapFromJson(content, Agency[].class);
        assertTrue(agencies.length >= 0);

    }
    @Test
    public void createAgency() throws Exception{
        String uri = "/agencies";
        Agency agency = new Agency();
        agency.setPlaceCode(3L);
        agency.setName("xxx");
        agency.setSwiftCode("yyy");
        agency.setDate(new Date());
        agency.setBankCode("000");

        String inputJson = super.mapToJson(agency);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "The agency created successfully");

    }
    @Test
    public void updateAgency()throws Exception{
        String uri = "/agencies";
        Agency agency = agencyRepository.findAll().get(0);

        agency.setName("newName");
        String inputJson = super.mapToJson(agency);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Manager updated successfully");

    }

}
