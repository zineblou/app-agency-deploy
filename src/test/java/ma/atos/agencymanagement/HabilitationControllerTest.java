package ma.atos.agencymanagement;

import ma.atos.agencymanagement.model.Habilitation;

import ma.atos.agencymanagement.repository.HabilitationRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HabilitationControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Autowired
    HabilitationRepository habilitationRepository;

    @Test
    public void getHabiliattionsList() throws Exception {
        String uri = "/habilitation/habilitations";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        //Verify request succeed
        assertEquals(200, status);

    }

    @Test
    public void createHabilitation() throws Exception {
        String uri = "/habilitation/addHabilitation";
        Habilitation habilitation = new Habilitation();
        habilitation.setName("x");
        habilitation.setCode("y");
        habilitation.setStartDate(new Date());
        habilitation.setEndDate(new Date());
        String inputJson = super.mapToJson(habilitation);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void updateHabilitation() throws Exception {

        String uri = "/habilitation/update";
        Habilitation habilitation = habilitationRepository.findAll().get(0);
        System.out.println("get name:"+habilitation.getName());
        habilitation.setName("newName");
        String inputJson = super.mapToJson(habilitation);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void deleteHabilitation() throws  Exception{
        Habilitation habilitation = habilitationRepository.findAll().get(0);
        String uir = "/habilitation/delete/"+habilitation.getId();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uir)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }


}