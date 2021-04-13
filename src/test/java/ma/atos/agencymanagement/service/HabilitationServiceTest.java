package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HabilitationServiceTest {
    @InjectMocks
    @Autowired
    private HabilitationService habilitationService;
    @Mock
    @Autowired
    private HabilitationRepository habilitationRepository;

    private Habilitation habilitationTest = new Habilitation();


    @Before("")
    public void init() {
        habilitationTest = new Habilitation("Writing", "A23", new Date(), new Date());

    }


    @Test
    void getHabilitations() {
        Habilitation habilitationTest2 = new Habilitation("Writing", "A23", new Date(), new Date());
        Habilitation habilitationTest3 = new Habilitation("Writing", "A23", new Date(), new Date());
        habilitationRepository.save(habilitationTest2);
        habilitationRepository.save(habilitationTest3);
        Mockito.doReturn(Arrays.asList(habilitationTest2, habilitationTest2)).when(habilitationRepository).findAll();
        List<Habilitation> habilitations = habilitationService.getHabilitations();
        Assertions.assertEquals(2, habilitations.size(), "findAll should return 2 widgets");
    }


    @Test
    public void getHabilitationById() {

        when(habilitationRepository.findById(1L)).thenReturn(Optional.of(habilitationTest));
        Optional<Habilitation> returnedHabilitations = Optional.ofNullable(habilitationService.getHabilitationById(1L));


        // Give the response
        Assertions.assertTrue(returnedHabilitations.isPresent(), "Widget was not found");
        Assertions.assertSame(returnedHabilitations.get(), habilitationTest, "The widget returned was not the same as the mock");

    }


    @Test
    void saveHabilitation() {

        /// Setup our mock repository
        Habilitation habilitationTest3 = new Habilitation("Writing", "A23", new Date(), new Date());


        when(habilitationRepository.save(habilitationTest3)).thenReturn(habilitationTest3);

        //Then
        Habilitation returned = habilitationRepository.save(habilitationTest3);

        assertNotNull(returned);
        assertEquals(habilitationTest3, returned);

        assertEquals("A23", returned.getName());
        verify(habilitationRepository, times(1)).save(habilitationTest3);

    }

    @Test
    void deleteHabilitation() {
        habilitationService.deleteHabilitation(1L);

        verify(habilitationRepository, times(1)).deleteById(1L);
    }



}
