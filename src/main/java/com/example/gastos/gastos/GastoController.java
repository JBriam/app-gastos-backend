package com.example.gastos.gastos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para manejar operaciones sobre Gasto.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/gastos")
public class GastoController {
   @Autowired
    private GastoService gastoService;

    /**
     * Obtiene una lista de todos los gastos.
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<GastoDTO>> getAllGastos() {
        return ResponseEntity.ok(gastoService.findAll());
    }

    /**
     * Obtiene un gasto por su ID.
     *
     * @param id el identificador del gasto
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<GastoDTO> getGastoById(@PathVariable Long id) {
        return ResponseEntity.ok(gastoService.findById(id));
    }

    /**
     * Crea un nuevo gasto.
     *
     * @param gasto el objeto ProductoDTO a crear
     * @return una respuesta HTTP 201 si se crea correctamente
     */
    @PostMapping
    public ResponseEntity<GastoDTO> createGasto(@RequestBody GastoDTO gasto) {
        gastoService.save(gasto);
        return ResponseEntity.status(HttpStatus.CREATED).body(gasto);
    }

    /**
     * Actualiza un gasto existente.
     *
     * @param id el identificador del gasto a actualizar
     * @param gasto el objeto GastoDTO con los datos actualizados
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGasto(@PathVariable Long id, @RequestBody GastoDTO gasto) {
        gasto.setId(id);
        gastoService.update(gasto);
        return ResponseEntity.ok().build();
    }

    /**
     * Elimina un gasto por su ID.
     *
     * @param id el identificador del gasto a eliminar
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        gastoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
