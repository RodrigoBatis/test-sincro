package br.com.sincro.testeSincro.repository;

import br.com.sincro.testeSincro.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
