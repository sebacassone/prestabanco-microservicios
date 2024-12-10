package cl.prestabanco.loans_server.controllers;

import cl.prestabanco.loans_server.entities.RequestsEntity;
import cl.prestabanco.loans_server.models.RequestsWithTypeLoan;
import cl.prestabanco.loans_server.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/requests")
@CrossOrigin("*")
public class RequestsController {
    @Autowired
    private RequestsService requestsService;

    @PostMapping("/save-request")
    public ResponseEntity<RequestsEntity> saveRequest(@RequestBody Map<String, Object> jsonMap){
        try {
            System.out.println("Request: " + jsonMap);
            // the request is saved in database
            RequestsEntity response = requestsService.saveRequest(
                    (String) jsonMap.get("stateRequest"),
                    (Integer) jsonMap.get("leanRequest"),
                    (Integer) jsonMap.get("userRequest")
            );

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get-all-requests")
    public ResponseEntity<List<RequestsWithTypeLoan>> getAllRequests() {
        try {
            List<RequestsWithTypeLoan> response = requestsService.getAllRequests();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update-request/{idRequest}")
    public ResponseEntity<RequestsEntity> updateRequest(@PathVariable("idRequest") Integer idRequest, @RequestBody Map<String, Object> jsonMap) {
        try {
            RequestsEntity response = requestsService.updateRequest(
                    idRequest,
                    (String) jsonMap.get("stateRequest"),
                    (Integer) jsonMap.get("idEvaluation")
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get-request/{idUser}")
    public ResponseEntity<List<RequestsWithTypeLoan>> getRequestById(@PathVariable("idUser") Integer idUser){
        try {
            List<RequestsWithTypeLoan> response = requestsService.getRequestByIdUser(idUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
