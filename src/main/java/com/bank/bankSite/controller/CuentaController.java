package com.bank.bankSite.controller;

import com.bank.bankSite.model.*;
import com.bank.bankSite.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.bankSite.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ChequeRepository chequeRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    /**
     * Update product response entity.
     *
     * @param cuentaId      the product id
     * @param cuentaDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("v2/cuentas/{id}")
    public ResponseEntity<Cuenta> updateProduct(
            @PathVariable(value = "id") Long cuentaId, @Valid @RequestBody Cuenta cuentaDetails)
            throws ResourceNotFoundException {

        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        cuenta.setSaldo(cuenta.getSaldo() + cuentaDetails.getSaldo());
        final Cuenta updatedCuenta = cuentaRepository.save(cuenta);
        return ResponseEntity.ok(updatedCuenta);
    }

    @GetMapping("v2/cuentas/{id}/cheques")
    public List<Cheque> getAllCheques(@PathVariable(value = "id") Long cuentaId) throws ResourceNotFoundException {
        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        return chequeRepository.findByCuenta(cuenta);
    }

    @GetMapping("v2/cuentas/{id}/pagos")
    public List<Pago> getAllPagos(@PathVariable(value = "id") Long cuentaId) throws ResourceNotFoundException {
        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        return pagoRepository.findByCuenta(cuenta);
    }

    /**
     * Delete product map.
     *
     * @param cuentaId the product id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("v2/cuentas/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long cuentaId) throws Exception {
        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        cuentaRepository.delete(cuenta);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * @param cuentaId      the product id
     * @param chequeDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PostMapping("v2/cuentas/{id}/cheques")
    public ResponseEntity<Cheque> createCheque(
            @PathVariable(value = "id") Long cuentaId, @Valid @RequestBody Cheque chequeDetails)
            throws ResourceNotFoundException {

        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        chequeDetails.setCuenta(cuenta);
        final Cheque chequeNuevo = chequeRepository.save(chequeDetails);
        return ResponseEntity.ok(chequeNuevo);
    }

    /**
     * @param cuentaId    the product id
     * @param pagoDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PostMapping("v2/cuentas/{id}/pagos")
    public ResponseEntity<Pago> createPago(
            @PathVariable(value = "id") Long cuentaId, @Valid @RequestBody Pago pagoDetails)
            throws ResourceNotFoundException {

        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        if (pagoDetails.getIdPrestamo() > 0) {
            Prestamo prestamo =
                    prestamoRepository
                            .findById((long) pagoDetails.getIdPrestamo())
                            .orElseThrow(() -> new ResourceNotFoundException("Prestamo not found on :: " + pagoDetails.getIdPrestamo()));

            pagoDetails.setPrestamo(prestamo);
            prestamo.setSaldo(prestamo.getSaldo() - pagoDetails.getMonto());
            prestamoRepository.save(prestamo);
        }

        if (pagoDetails.getIdServicio() > 0) {
            Servicio servicio =
                    servicioRepository
                            .findById((long) pagoDetails.getIdServicio())
                            .orElseThrow(() -> new ResourceNotFoundException("Servicio not found on :: " + pagoDetails.getIdServicio()));

            pagoDetails.setServicio(servicio);
        }

        if (pagoDetails.getIdTarjeta() > 0) {
            Tarjeta tarjeta =
                    tarjetaRepository
                            .findById((long) pagoDetails.getIdTarjeta())
                            .orElseThrow(() -> new ResourceNotFoundException("Tarjeta not found on :: " + pagoDetails.getIdTarjeta()));

            pagoDetails.setTarjeta(tarjeta);
            tarjeta.setMontoUsado(tarjeta.getMontoUsado() - pagoDetails.getMonto());
            tarjetaRepository.save(tarjeta);
        }

        cuenta.setSaldo(cuenta.getSaldo() - pagoDetails.getMonto());
        cuentaRepository.save(cuenta);
        pagoDetails.setCuenta(cuenta);
        final Pago pagoNuevo = pagoRepository.save(pagoDetails);
        return ResponseEntity.ok(pagoNuevo);
    }
}
