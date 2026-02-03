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

    @NotBlank
    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "ds_sku")
    private String sku;

    @Column(name = "ds_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_category", nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_location", nullable = false)
    private Location location;

    @Column(name = "dt_date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_depreciationmethod")
    private DepreciationMethod depreciationMethod;

    @Column(name = "vl_depreciationrate")
    private Double depreciationRate;

    @Column(name = "vl_residualvalue")
    private Double residualValue;

    @NotNull
    @Column(name = "vl_quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "vl_minimiumstock", nullable = false)
    private Integer minimiumStock;

    @NotNull
    @Column(name = "vl_unitprice", nullable = false)
    private Double unitPrice;
}
