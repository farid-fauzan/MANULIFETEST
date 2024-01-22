package com.manulife.rest.services;

import com.manulife.rest.entity.Catatan;
import com.manulife.rest.pojo.CatatanPojo;
import com.manulife.rest.respository.CatatanRepository;
import com.manulife.rest.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatatanService {

    @Autowired
    private CatatanRepository catatanRepository;


    public ResponseEntity all() {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            List<Catatan> list = catatanRepository.findAll();
            if (list.size()>0){
                msg.setStatus(true);
                msg.setMessage("Berhasil Get Data!");
                msg.setData(list);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Data Tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity findById(Long id) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Catatan catatan = catatanRepository.findByid(id);
            if (catatan!=null){
                msg.setStatus(true);
                msg.setMessage("Berhasil Get Data!");
                msg.setData(catatan);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Data Tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity add(CatatanPojo catatanPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Catatan catatan = new Catatan();
            catatan.setTitle(catatanPojo.getTitle());
            catatan.setDescription(catatanPojo.getDescription());
            catatan.setAuthor(catatanPojo.getAuthor());
            catatan.setCreatedt(catatanPojo.getCreatedt());
            catatan.setUpdatedAt(catatanPojo.getUpdatedAt());
            catatanRepository.save(catatan);

            msg.setStatus(true);
            msg.setMessage("Berhasil Save Data!");
            msg.setData(catatan);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity update(Long id, CatatanPojo catatanPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Catatan catatan = new Catatan();
            catatan.setId(id);
            catatan.setTitle(catatanPojo.getTitle());
            catatan.setDescription(catatanPojo.getDescription());
            catatan.setAuthor(catatanPojo.getAuthor());
            catatan.setCreatedt(catatanPojo.getCreatedt());
            catatan.setUpdatedAt(catatanPojo.getUpdatedAt());
            catatanRepository.save(catatan);

            msg.setStatus(true);
            msg.setMessage("Berhasil Update Data!");
            msg.setData(catatan);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity delete(Long id) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            catatanRepository.deleteById(id);

            msg.setStatus(true);
            msg.setMessage("Berhasil Delete Data!");
            msg.setData(null);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

}
