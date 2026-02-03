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
                                       @Validated @RequestBody Item item) {

        Item existing = service.findById(id);

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
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
