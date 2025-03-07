package ch.so.agi.simi.entity.product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "SIMIPRODUCT_PROPERTIES_IN_LIST", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_SIMI_PROPERTIES_IN_LIST_UNQ_PRODUCT_LIST_ID_SINGLE_ACTOR_ID", columnNames = {"PRODUCT_LIST_ID", "SINGLE_ACTOR_ID"})
})
@Entity(name = "simiProduct_PropertiesInList")
public class PropertiesInList extends ChildLayerProperties {
    private static final long serialVersionUID = 3933249168854903665L;

    @NotNull
    @Column(name = "VISIBLE", nullable = false)
    private Boolean visible = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_LIST_ID")
    @NotNull
    private ProductList productList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SINGLE_ACTOR_ID")
    @NotNull
    private SingleActor singleActor;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public SingleActor getSingleActor() {
        return singleActor;
    }

    public void setSingleActor(SingleActor singleActor) {
        this.singleActor = singleActor;
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }
}