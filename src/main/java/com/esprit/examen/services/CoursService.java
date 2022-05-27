package com.esprit.examen.services;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CoursService implements ICoursService {
	private static final Logger log = LogManager.getLogger(CoursService.class);

	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionRepository sessionRepository;

	@Override
	public Long addCours(Cours cours) {
		try {
			log.debug("process saving ", cours);
			coursRepository.save(cours);
			log.debug("cour saved ", cours);
	}catch (Exception e){
			log.error("error while saving cour : "+ e.getMessage());
		}
		log.info("save complete");
			return cours.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public void supprimerCours(Long coursId) {
		try {
		coursRepository.deleteById(coursId);
		log.debug("cour deleted ", coursId);
		}catch (Exception e){
			log.error("error while removing cour : "+ e.getMessage());
		}
		log.info("delete complete");

	}

	@Override
	public List<Cours> getCours() {

		List<Cours> cours = coursRepository.findAll();
		return cours;
	}

	@Override
	public void affecterCoursASession(Long coursId, Long sessionId) {
		
		try {
			Cours cours = coursRepository.findById(coursId).get();
			log.debug("cour to add", cours);
			Session s = sessionRepository.findById(sessionId).get();
			Set<Cours> coursList = s.getCours();
		    coursList.add(cours);
		    s.setCours(coursList);
		    sessionRepository.save(s);
			log.debug("cour added ", cours);
			}catch (Exception e){
				log.error("error while adding cour : "+ e.getMessage());
			}
			log.info("adding complete");

	}

}