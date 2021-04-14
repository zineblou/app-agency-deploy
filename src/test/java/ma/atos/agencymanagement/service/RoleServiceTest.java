package ma.atos.agencymanagement.service;


import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RoleServiceTest {
    @InjectMocks
    private RoleService roleService;
    @Mock
    private RoleRepository roleRepository;
    @InjectMocks
    private Role roleTest = new Role();

    @Before("")
    public void init() {
      roleTest = new Role(1L, "Writing", "A23");

    }


    @Test
    void getById() {

        when(roleRepository.findById(1L)).thenReturn(Optional.of(roleTest));
        Optional<Role> returnedROles = Optional.ofNullable(roleService.getById(1L));


        // Assert the response
        Assertions.assertTrue(returnedROles.isPresent(), "ROLE was not found");
        Assertions.assertSame(returnedROles.get(), roleTest, "The ROLE returned was not the same as the mock");

    }


    @Test
    void getRoles() {
        Role roleTest2 = new Role(1L, "Writing", "A23");
        Role roleTest3 = new Role(1L, "Writing", "A23");
        doReturn(Arrays.asList(roleTest2, roleTest2)).when(roleRepository).findAll();
        List<Role> roles = roleService.getRoles();
        Assertions.assertEquals(2, roles.size(), "findAll should return 2 Roles");
    }


    @Test
    void saveRole() {
        /// Setup our mock repository
        Role roleTest3 = new Role(1L, "Writing2", "A2344");


        when(roleRepository.save(roleTest3)).thenReturn(roleTest3);

        //Then
        Role returned = roleRepository.save(roleTest3);

        assertNotNull(returned);
        assertEquals(roleTest3, returned);

        assertEquals("Writing2", returned.getName());
        verify(roleRepository, times(1)).save(roleTest3);

    }

    @Test
    void deletRole() {
        roleService.deletRole(1L);

        Mockito.verify(roleRepository, times(1)).deleteById(1L);
    }


}