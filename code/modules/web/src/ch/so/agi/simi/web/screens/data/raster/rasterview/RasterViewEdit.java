package ch.so.agi.simi.web.screens.data.raster.rasterview;

import ch.so.agi.simi.entity.data.raster.RasterView;
import ch.so.agi.simi.entity.iam.Permission;
import ch.so.agi.simi.entity.product.DataSetView;
import ch.so.agi.simi.entity.product.DataSetView_SearchTypeEnum;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.ValidationException;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("simiData_RasterView.edit")
@UiDescriptor("raster-view-edit.xml")
@EditedEntityContainer("dataProductDc")
@LoadDataBeforeShow
public class RasterViewEdit extends StandardEditor<RasterView> {
    @Inject
    private CollectionPropertyContainer<Permission> permissionsDc;
    @Inject
    private DataContext dataContext;
    @Inject
    private InstanceContainer<RasterView> dataProductDc;
    @Inject
    private Messages messages;
    @Inject
    private TextField<String> searchFilterWordField;
    @Inject
    private Table<Permission> permissionsTable;

    @Subscribe("addPermissionBtn")
    public void onAddPermissionBtnClick(Button.ClickEvent event) {
        Permission permission = dataContext.create(Permission.class);
        permission.setDataSetView(this.getEditedEntity());

        permissionsDc.getMutableItems().add(permission);

        permissionsTable.requestFocus(permission, "role");
    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        searchFilterWordField.addValidator(value -> {
            if (dataProductDc.getItem().getSearchType() != DataSetView_SearchTypeEnum.NEIN && (value == null || value.isEmpty()))
                throw  new ValidationException("Wenn Suchtyp '" +
                        messages.getMessage(DataSetView_SearchTypeEnum.class, "DataSetView_SearchTypeEnum.IMMER") + "' oder '" +
                        messages.getMessage(DataSetView_SearchTypeEnum.class, "DataSetView_SearchTypeEnum.FALLS_GELADEN") + "' ist, muss '" +
                        messages.getMessage(DataSetView.class, "DataSetView.searchFilterWord") + "' angegeben werden.");
        });
    }
}