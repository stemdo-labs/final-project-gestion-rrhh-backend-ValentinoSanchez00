package gm.rh.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gm.rh.repository.empleadoRepository;
import gm.rh.entity.Empleado;


import java.util.List;

@Service
@AllArgsConstructor
public class empleadoService {

    @Autowired
    private final empleadoRepository empleadoRepository;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElse(null);
        return empleado;
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

}
