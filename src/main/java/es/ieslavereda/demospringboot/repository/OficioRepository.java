package es.ieslavereda.demospringboot.repository;

import es.ieslavereda.demospringboot.model.Oficio;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository

public class OficioRepository {

    private List<Oficio> oficios;

    public OficioRepository() {
        oficios = new ArrayList<>();
        oficios.add(new Oficio(1,"Tabernero"));
        oficios.add(new Oficio(2,"Doctor"));
        oficios.add(new Oficio(3,"Constructor"));
        oficios.add(new Oficio(4,"Programador"));
    }

    public List<Oficio> getAllOficios() {
        return oficios;
    }

    public Oficio crearOficio(Oficio oficio) {
        oficios.add(oficio);
        return oficio;
    }

    public Oficio findOficio(int id) {
        for (Oficio oficio : oficios) {
            if (oficio.getId_oficio()==id)
                return oficio;
        }
        return null;
    }

    public Oficio updateOficio(Oficio oficio) throws SQLException {
        if (findOficio(oficio.getId_oficio())==null) {
            throw new SQLException("No existe ese oficio"  + oficio);
        }else {
            Oficio old = findOficio(oficio.getId_oficio());
            old.setId_oficio(oficio.getId_oficio());
            old.setOficio(oficio.getOficio());
            return old;
        }
    }

    public Integer removeByID(Integer id) throws SQLException {
        Iterator<Oficio> iterator = oficios.iterator();
        while (iterator.hasNext()) {
            Oficio oficio = iterator.next();
            if (oficio.getId_oficio()==id) {
                int id2=iterator.next().getId_oficio();
                iterator.remove();
                return id2;
            }
        }
        throw new SQLException("No existe el Oficio" + id);
    }
}
