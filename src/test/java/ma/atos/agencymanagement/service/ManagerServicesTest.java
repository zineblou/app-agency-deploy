package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.repository.ManagerRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class ManagerServiceTest {

    @InjectMocks
    private ManagerService managerService;
    @Mock
    private ManagerRepository managerRepository;
    private Manager managerTest = new Manager();

    @Before("")
    public void init() {
        managerTest = new Manager("Writing", "A23","122",new Date());

    }





    @Test
    void getManagers() {
        Manager managerTest2 = new Manager("Writing", "A23","122",new Date());
        Manager managerTest3 = new Manager("Writing", "A23","122",new Date());
        Mockito.doReturn(Arrays.asList(managerTest2, managerTest2)).when(managerRepository).findAll();
        List<Manager> managers = managerService.getManagers();
        Assertions.assertEquals(2, managers.size(), "findAll should return 2 widgets");
    }


    @Test
    void saveManager() {
        /// Setup our mock repository
        Manager managerTest3 = new Manager("Writing", "A23","122",new Date());


        when(managerRepository.save(managerTest3)).thenReturn(managerTest3);

        //Then
        Manager returned = managerRepository.save(managerTest3);

        assertNotNull(returned);
        assertEquals(managerTest3, returned);

        assertEquals("A23", returned.getFirstName());
        verify(managerRepository, times(1)).save(managerTest3);

    }

    @Test
    void deleteManager() {
        managerService.deleteManager(1L);

        verify(managerRepository, times(1)).deleteById(1L);
    }




}

