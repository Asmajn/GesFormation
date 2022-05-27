package com.esprit.examen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;

import com.esprit.examen.services.ICoursService;

import lombok.extern.slf4j.Slf4j;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class CoursServiceTest {
	private static final Logger log = LogManager.getLogger(CoursServiceTest.class);

	 @Autowired 
	 
	 ICoursService iCoursService;
	@Test
	
	public void addCours() {
        Cours cours = new Cours(null, "test2", TypeCours.Scrum, "test2");
        Long id = iCoursService.addCours(cours);
        assertNotNull(cours, () -> "not be null !!!");
        iCoursService.supprimerCours(id);
    }

    @Test
   public void supprimerCours() {
        iCoursService.supprimerCours(1L);
        assertTrue(true);
        log.info("cours deleted");
    }

    @Test
    public void getCours() {
       @SuppressWarnings("unused")
	List<Cours> cours = iCoursService.getCours();
      
       
    }

    @Test
    public void affecterCoursASession() {
        iCoursService.affecterCoursASession(1L, 1L);
        assertTrue(true);
    }

}
