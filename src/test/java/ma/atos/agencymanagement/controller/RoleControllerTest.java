package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.AbstractTest;

import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.AgencyRepository;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import ma.atos.agencymanagement.repository.ManagerRepository;
import ma.atos.agencymanagement.repository.RoleRepository;
import ma.atos.agencymanagement.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import ma.atos.agencymanagement.model.Habilitation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoleControllerTest extends AbstractTest {

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
    @Autowired
    HabilitationRepository habilitationRepository;
    @MockBean
    private RoleService roleService;

    @Test
    public void addRole() throws Exception {
        String uri = "/addrole";
        Role role = new Role("12453", "CREATIVE");
        String inputJson = super.mapToJson(role);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void getRoles() throws Exception {
        String uri = "/listroles";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        Role[] listroles = super.mapFromJson(content, Role[].class);
        assertTrue(listroles.length >= 0);
    }

    @Test
    public void getRoleById() throws Exception {
        String uri = "/role/1";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void updateRole() throws Exception {

        String uri = "/update";
        Role role = roleRepository.findAll().get(5);
        role.setName("SAMED");
        role.setCode("K4578");
        String inputJson = super.mapToJson(role);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void deleteRole() throws Exception {
        Role role = roleRepository.findAll().get(0);
        String uir = "/deleteRole/" + role.getId();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uir)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void assignHabilitation() throws Exception {
        Role role = roleRepository.findAll().get(0);
        Habilitation habilitation = habilitationRepository.findAll().get(0);
        String uri = "/assignHabilition";

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();

        requestParams.add("roleId", " " + role.getId());
        requestParams.add("habilitationId", " " + habilitation.getId());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).params(requestParams)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}