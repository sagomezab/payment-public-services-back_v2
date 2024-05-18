package edu.escuelaing.arem.ASE.app.controller;

import edu.escuelaing.arem.ASE.app.model.RespuestaPago;
import edu.escuelaing.arem.ASE.app.model.TxrModel;
import edu.escuelaing.arem.ASE.app.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/payments")
@CrossOrigin(origins = "*")
class PaymentController {

    @Autowired
    private TransaccionService transaccionService;

    @PostMapping()
    public ResponseEntity<RespuestaPago> payment(@RequestBody TxrModel txrModel) {
        return transaccionService.payment(txrModel);
    }

    @GetMapping("/{user}")
    public ResponseEntity<?> getPayments(@PathVariable String user) {
        List<Object> txr = transaccionService.getPayments(user);
        if (txr != null) {
            return new ResponseEntity<>(txr, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/estado/{status}/user/{user}")
    public ResponseEntity<?> getPaymentsStatusByUser(@PathVariable String status, @PathVariable String user) {
        List<Object> txr = transaccionService.getPaymentsStatusByUser(status, user);
        if (txr != null) {
            return new ResponseEntity<>(txr, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/factura/{id_factura}")
    public ResponseEntity<?> getPaymentsByFactura(@PathVariable String id_factura) {
        List<Object> txr = transaccionService.getPaymentsByFactura(id_factura);
        if (txr != null) {
            return new ResponseEntity<>(txr, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
