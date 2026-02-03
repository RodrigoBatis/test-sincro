package br.com.sincro.testeSincro.service;

import br.com.sincro.testeSincro.model.Item;
import br.com.sincro.testeSincro.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository){
        this.repository = repository;
    }

    public Item save(Item item){
        return repository.save(item);
    }

    public List<Item> findAll(){
        return repository.findAll();
    }

    public Optional<Item> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
