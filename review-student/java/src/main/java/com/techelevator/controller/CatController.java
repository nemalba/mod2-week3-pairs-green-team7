package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController {

    @Autowired
    private CatCardDao catCardDao;

    @Autowired
    private CatFactService catFactService;

    @Autowired
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    //****************************************************************
    /**
     * Return All CatCards
     *
     * @return a list of all catCard in the system
     */

    @RequestMapping(path = "/cards", method = RequestMethod.GET)
    public List<CatCard> list( ){
        List<CatCard> catCardList =catCardDao.list();
        return catCardList;
    }
    //****************************************************************
    /**
     * Return  Cat Card information
     *
     * @param id the id of the cat card
     * @return all info for a given cat card
     */
    @RequestMapping(path = "/cards/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable int id) {

        return catCardDao.get(id);
    }
    //****************************************************************

    @RequestMapping( path = "/api/cards", method = RequestMethod.POST)
    public boolean create(@RequestBody CatCard catCard) {
        return catCardDao.save(catCard);
    }
    //****************************************************************

    
}
