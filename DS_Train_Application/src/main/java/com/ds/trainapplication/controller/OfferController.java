package com.ds.trainapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.trainapplication.mapping.Offer;
import com.ds.trainapplication.service.OfferService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/offer")
@Api(value = "Offer Controller")
@CrossOrigin(value = "http://localhost:4200")
public class OfferController {
	
private OfferService offerService;
	
	@Autowired
	public OfferController(OfferService offerService) {
		this.offerService = offerService;
	}
	
	@ApiOperation(value = "View All Offers")
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Offer> listDestination() {
		return offerService.listOffers();
	}

}
