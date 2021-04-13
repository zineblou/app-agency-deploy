package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.AgencyRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
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
class AgencyServiceTest {

    @InjectMocks
    AgencyService agencyService;
    @Mock
    AgencyRepository agencyRepository;
    private Agency agencyTest ;
    @Before("")
    public void init() {


    }
    @Test
    void getAllAgencies() {

        Agency    agencyTest2 = new Agency(1L, "wqafaSAlaf", "A", "AJJLKLK");
        Agency    agencyTest3 = new Agency(1L, "wqafaSAlaf", "A", "AJJLKLK");
        doReturn(Arrays.asList(agencyTest2,  agencyTest3)).when(agencyRepository).findAll();
        List<Agency> agncys = agencyService.getAllAgencies();
        Assertions.assertEquals(2, agncys.size(), "findAll should return 2 Agencies");
    }

    @Test
    void getAgency() {
        Agency    agencyTest = new Agency(1L, "wqafaSAlaf", "A", "AJJLKLK");
        when(agencyRepository.findById(1L)).thenReturn(Optional.of(agencyTest));
        Optional<Optional<Agency>> returnedAgency = Optional.ofNullable(agencyService.getAgency(1L));
        // Assert the response
        Assertions.assertTrue(returnedAgency.isPresent(), "Agency was not found");
//
    }

    @Test
    void addAgency() {
        Agency    agencyTest3 = new Agency(1L, "wqafaSAlaf", "A", "AJJLKLK");

//
        when(agencyRepository.save(agencyTest3 )).thenReturn(agencyTest3 );

        //Then
       Agency returned = (Agency) agencyRepository.save(agencyTest3);

        assertNotNull(returned);
        assertEquals(agencyTest3, returned);

        assertEquals("wqafaSAlaf", returned.getName());
        verify(agencyRepository, times(1)).save(agencyTest3);

    }



    @Test
    void deleteAgency() {
        agencyService.deleteAgency(1L);

        verify(agencyRepository, times(1)).deleteById(1L);
    }


}