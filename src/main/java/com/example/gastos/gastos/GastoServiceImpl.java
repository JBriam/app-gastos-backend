package com.example.gastos.gastos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

/**
 * Implementación del servicio de Gasto
 */
@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;
    
    /**
     * Convierte una entidad Gasto a GastoDTO.
     *
     * @param g la entidad Gasto
     * @return
     */
    public GastoDTO convertToDTO(Gasto g) {
        return new GastoDTO(
                g.getId(),
                g.getCategoria(),
                g.getDescripcion(),
                g.getMonto(),
                g.getFecha(),
                g.getHora()
        );
    }

    /**
     * Obtiene una lista de todos los gastos.
     *
     * @return
     */
    @Override
    public List<GastoDTO> findAll() {
        List<Gasto> gastos = gastoRepository.findAll();

        return gastos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca un gasto por su ID.
     *
     * @param id el identificador del gasto
     * @return
     */
    @Override
    public GastoDTO findById(Long id) {
        return gastoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Gasto no encontrado con ID: " + id));
    }

    /**
     * Guarda un nuevo gasto.
     *
     * @param gasto el objeto GastoDTO a guardar
     */
    @Override
    public void save(GastoDTO gasto) {
        Gasto g = new Gasto();
        g.setCategoria(gasto.getCategoria());
        g.setDescripcion(gasto.getDescripcion());
        g.setMonto(gasto.getMonto());
        g.setFecha(LocalDate.now());  // Asignar fecha a la ENTIDAD
        g.setHora(LocalTime.now());   // Asignar hora a la ENTIDAD

        gastoRepository.save(g);
    }

    /**
     * Actualiza un gasto existente.
     *
     * @param gasto
     */
    @Override
    public void update(GastoDTO gasto) {
        Gasto g = gastoRepository.findById(gasto.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Gasto no encontrado con ID: " + gasto.getId()));

        g.setCategoria(gasto.getCategoria());
        g.setDescripcion(gasto.getDescripcion());
        g.setMonto(gasto.getMonto());

        gastoRepository.save(g);
    }

    /**
     * Elimina un gasto por su ID.
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        if (!gastoRepository.existsById(id)) {
            throw new EntityNotFoundException("Gasto no encontrado con ID: " + id);
        }
        gastoRepository.deleteById(id);
    }
    
}
