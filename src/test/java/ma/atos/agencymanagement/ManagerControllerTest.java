package ma.atos.agencymanagement;
import ma.atos.agencymanagement.controller.ManagerController;
import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Manager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.AgencyRepository;
import ma.atos.agencymanagement.repository.ManagerRepository;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
 import org.springframework.test.web.servlet.MvcResult;
 import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import java.util.Date;
import java.util.function.Supplier;


public class ManagerControllerTest extends AbstractTest {


    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AgencyRepository agencyRepository;
    @Test
    public void getManagersList() throws Exception {
        String uri = "/manager/managers";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Manager[] managerlist = super.mapFromJson(content, Manager[].class);
        assertTrue(managerlist.length >= 0);
    }
    @Test
    public void createManager() throws Exception {
        String uri = "/manager/addManager";
        Manager manager = new Manager();
        manager.setFirstName("x");
        manager.setLastName("y");
        manager.setIntegrationDate(new Date());
        String inputJson = super.mapToJson(manager);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "The manager created successfully");
    }
    @Test
    public void updateManager() throws Exception {
        String uri = "/manager/update";
        Manager manager = managerRepository.findAll().get(0);
        Logger logger = LoggerFactory.getLogger(ManagerControllerTest.class);

        Supplier<String> stringSupplier = () -> new String("manager name:\"+manager.getFirstName()");
        logger.info(stringSupplier);

        manager.setFirstName("newName");
        String inputJson = super.mapToJson(manager);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Manager updated successfully");
    }

    @Test
    public void deleteManager() throws  Exception{
        Manager manager = managerRepository.findAll().get(0);
        String uir = "/manager/delete/"+manager.getId();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uir)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    public void assignManager() throws  Exception{
        /**
         *         We used the last two elements of managers's list because
         *         the first element is deleted after the execution of the delete method
         */

        Manager manager = managerRepository.findAll().get(managerRepository.findAll().size()-1);
        Manager manager1 = managerRepository.findAll().get(managerRepository.findAll().size()-2);
        String uir = "/manager/assignManager";
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("id1", " "+manager.getId());
        requestParams.add("id2", " "+manager1.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uir).params(requestParams)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    public void assignRole() throws  Exception{
        Role role = roleRepository.findAll().get(roleRepository.findAll().size()-1);
        Manager manager = managerRepository.findAll().get(managerRepository.findAll().size()-1);
        String uir = "/manager/assignRole";
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("idRole", " "+role.getId());
        requestParams.add("idManager", " "+manager.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uir).params(requestParams)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }


    @Test
    public void assignAgency() throws  Exception{
        Agency agency = agencyRepository.findAll().get(agencyRepository.findAll().size()-1);
        Manager manager = managerRepository.findAll().get(managerRepository.findAll().size()-1);
        String uir = "/manager/assignAgency";
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("idManager", " "+manager.getId());
        requestParams.add("idAgency", " "+agency.getPlaceCode());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uir).params(requestParams)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }
}