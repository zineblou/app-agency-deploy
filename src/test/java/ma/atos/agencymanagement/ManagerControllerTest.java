package ma.atos.agencymanagement;
import ma.atos.agencymanagement.model.Manager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
 import org.springframework.test.web.servlet.MvcResult;
 import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

public class ManagerControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getManagersList() throws Exception {
        String uri = "/manager/managers";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println("status "+status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Manager[] managerlist = super.mapFromJson(content, Manager[].class);
        assertTrue(managerlist.length > 0);
    }


}