package es.ieslavereda.demospringboot.service;

import es.ieslavereda.demospringboot.model.Oficio;
import es.ieslavereda.demospringboot.repository.OficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OficioService {

    @Autowired
    private OficioRepository oficioRepository;

    public Oficio crearOficio(Oficio oficio) {
        return oficioRepository.crearOficio(oficio);
    }

    public List<Oficio> getAllOficios() {
        return oficioRepository.getAllOficios();
    }

    public Oficio updateOficio(Oficio oficio) throws SQLException {
        return oficioRepository.updateOficio(oficio);
    }

    public Integer removeOficio(Integer id) throws SQLException {
        return oficioRepository.removeByID(id);
    }
}
