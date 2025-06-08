package com.example.gastos.gastos;

import java.util.List;

public interface GastoService {
    /**
     * Obtiene una lista de todos los gastos
     *
     * @return una lista de objetos de tipo Gastos
     */
    List<GastoDTO> findAll();

    /**
     * Busca un gasto por su ID.
     *
     * @param id el identificador del gasto
     * @return el gasto encontrada o null si no existe
     */
    GastoDTO findById(Long id);

    /**
     * Guarda un nuevo  gasto en la base de datos.
     *
     * @param gasto el objeto GastoDTO que contiene los datos del gasto a guardar
     * @throws IllegalArgumentException si los datos del gasto no son válidos
     */
    void save(GastoDTO gasto);

    /**
     * Actualiza un gasto existente en la base de datos.
     *
     * @param gasto el objeto GastoDTO que contiene los datos actualizados del gasto
     * @throws jakarta.persistence.EntityNotFoundException si el gasto con el ID especificado no existe
     */
    void update(GastoDTO gasto);

    /**
     * Elimina un gasto por su ID.
     *
     * @param id el identificador del gasto a eliminar
     */
    void delete(Long id);
}
