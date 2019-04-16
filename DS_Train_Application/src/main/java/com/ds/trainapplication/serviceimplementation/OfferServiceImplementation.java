package com.ds.trainapplication.serviceimplementation;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.trainapplication.mapping.Offer;
import com.ds.trainapplication.repository.OfferRepository;
import com.ds.trainapplication.service.OfferService;

@Service
public class OfferServiceImplementation implements OfferService{
	
	@Autowired
	private OfferRepository repository;
	
	private static final Logger logger = Logger.getLogger(OfferServiceImplementation.class);

	@Override
	public Iterable<Offer> listOffers() {
		logger.info("VIEW ALL OFFERS");
		return repository.findAll();
	}

}
