package es.ieslavereda.demospringboot.controller;

import es.ieslavereda.demospringboot.model.Oficio;
import es.ieslavereda.demospringboot.service.OficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestController


public class OficioController extends BaseController {

    private final Logger LOG = Logger.getLogger(getClass().getCanonicalName());

    @Autowired
    private OficioService oficioService;

    @PostMapping ("/Coficio")
    public ResponseEntity<?> createOficio(@RequestBody Oficio oficio){
        try {
            Oficio ofi=oficioService.crearOficio(oficio);
            LOG.log(Level.INFO,"Oficio creado");
            return new ResponseEntity<>(ofi, HttpStatus.CREATED);
        }catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping ("/Oficios")
    public ResponseEntity<?> showAllOficios(){
        try {
            List<Oficio> oficios=oficioService.getAllOficios();
            LOG.log(Level.INFO,"Devolviendo todos los oficios");
            return new ResponseEntity<>(oficios, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/uoficios")
    public ResponseEntity<?> updateOficio(@RequestBody Oficio oficio){
        try {
            Oficio ofi=oficioService.updateOficio(oficio);
            LOG.log(Level.INFO,"Oficio actualizado con la id: " + ofi.getId_oficio());
            return new ResponseEntity<>(oficio, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping ("/deloficios")
    public ResponseEntity<?> deleteOficiobyID(@RequestBody Integer idoficio){
        try {
            int idoficio1 = oficioService.removeOficio(idoficio);
            LOG.log(Level.INFO, "Oficio eliminado con id: " + idoficio1);
            return new ResponseEntity<>(idoficio1, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
