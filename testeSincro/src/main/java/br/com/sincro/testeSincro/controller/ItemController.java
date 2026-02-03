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
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Item> listAll(){
        return service.findAll();
    }

    @GetMapping("/{îd}")
    public ResponseEntity<Item>getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @Validated @RequestBody Item item){
        return service.findById(id)
                .map(existing -> {
                    existing.setName(item.getName());
                    existing.setSku(item.getSku());
                    existing.setDescription(item.getDescription());
                    existing.setCategory(item.getCategory());
                    existing.setLocation(item.getLocation());
                    existing.setDate(item.getDate());
                    existing.setDepreciationMethod(item.getDepreciationMethod());
                    existing.setDepreciationRate(item.getDepreciationRate());
                    existing.setResidualValue(item.getResidualValue());
                    existing.setQuantity(item.getQuantity());
                    existing.setMinimiumStock(item.getMinimiumStock());
                    existing.setUnitPrice(item.getUnitPrice());

                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
