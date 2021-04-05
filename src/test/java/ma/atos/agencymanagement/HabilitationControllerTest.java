package ma.atos.agencymanagement;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.model.Manager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HabilitationControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getHabiliattionsList() throws Exception {
        String uri = "/habilitation/habilitations";


        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println("status "+status);
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        Habilitation[] habilitationslist = super.mapFromJson(content, Habilitation[].class);
        assertTrue(habilitationslist.length > 0);
    }


}