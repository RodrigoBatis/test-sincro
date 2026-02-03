package br.com.sincro.testeSincro.model;

import br.com.sincro.testeSincro.enums.Category;
import br.com.sincro.testeSincro.enums.DepreciationMethod;
import br.com.sincro.testeSincro.enums.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "T_SINCRO_ITEM")
@SequenceGenerator(
        name = "SEQ_SINCRO_ITEM",
        sequenceName = "SEQ_SINCRO_ITEM",
        allocationSize = 1
)
@Data
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SINCRO_ITEM")
    @Column(name = "id_name")
    private Long id;

    @NotBlank(message = "Nome do item é obrigatório!")
    @Column(name = "ds_name")
    private String name;

    @Column(name = "ds_sku")
    private String sku;

    @Column(name = "ds_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_category", length = 255)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_location")
    private Location location;

    @Column(name = "dt_date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_depreciationMethod")
    private DepreciationMethod depreciationMethod;

    @Column(name = "vl_depreciationRate")
    private Double depreciationRate;

    @Column(name = "vl_residualValue")
    private Double residualValue;

    @Column(name = "vl_quantity")
    @NotNull(message = "Quantidade de itens é obrigatório!")
    private int quantity;

    @Column(name = "vl_minimiumStock")
    @NotNull(message = "Quantidade mínima de itens em estoque é obrigatório!")
    private int minimiumStock;

    @Column(name = "vl_unitPrice")
    @NotNull(message = "Valor unitário do item é obrigatório!")
    private Double unitPrice;

}
