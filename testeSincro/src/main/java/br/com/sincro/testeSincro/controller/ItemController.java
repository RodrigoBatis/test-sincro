package br.com.sincro.testeSincro.controller;

import br.com.sincro.testeSincro.model.Item;
import br.com.sincro.testeSincro.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@Validated @RequestBody Item item){
        Item saved = service.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Item> listAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item>getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id,
                                       @RequestBody Item item) {

        Item existing = service.findById(id);

        if (item.getName() != null && !item.getName().isBlank()) {
            existing.setName(item.getName());
        }

        if (item.getSku() != null) {
            existing.setSku(item.getSku());
        }

        if (item.getDescription() != null) {
            existing.setDescription(item.getDescription());
        }

        if (item.getCategory() != null) {
            existing.setCategory(item.getCategory());
        }

        if (item.getLocation() != null) {
            existing.setLocation(item.getLocation());
        }

        if (item.getDate() != null) {
            existing.setDate(item.getDate());
        }

        if (item.getDepreciationMethod() != null) {
            existing.setDepreciationMethod(item.getDepreciationMethod());
        }

        if (item.getDepreciationRate() != null) {
            existing.setDepreciationRate(item.getDepreciationRate());
        }

        if (item.getResidualValue() != null) {
            existing.setResidualValue(item.getResidualValue());
        }

        if (item.getQuantity() > 0) {
            existing.setQuantity(item.getQuantity());
        }

        if (item.getMinimiumStock() > 0) {
            existing.setMinimiumStock(item.getMinimiumStock());
        }

        if (item.getUnitPrice() != null) {
            existing.setUnitPrice(item.getUnitPrice());
        }

        return ResponseEntity.ok(service.save(existing));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
