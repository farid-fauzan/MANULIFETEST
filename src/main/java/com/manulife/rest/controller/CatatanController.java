package com.manulife.rest.controller;


import com.manulife.rest.pojo.CatatanPojo;
import com.manulife.rest.services.CatatanService;
import com.manulife.rest.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catatan")
public class CatatanController {

    @Autowired
    private CatatanService catatanServices;

    @GetMapping("/")
    public ResponseEntity<MessageModel> findAll() {

        return catatanServices.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageModel> findById(@PathVariable Long id) {

        return catatanServices.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<MessageModel> addMovie(@RequestBody CatatanPojo catatanPojo) {

        return catatanServices.add(catatanPojo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageModel> update(@PathVariable Long id, @RequestBody CatatanPojo catatanPojo) {
        return catatanServices.update(id,catatanPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageModel> update(@PathVariable Long id) {
        return catatanServices.delete(id);
    }



}
