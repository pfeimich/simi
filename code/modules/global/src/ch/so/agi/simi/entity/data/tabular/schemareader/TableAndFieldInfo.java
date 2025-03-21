package ch.so.agi.simi.entity.data.tabular.schemareader;

import ch.so.agi.simi.entity.data.tabular.PostgresDB;
import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

import java.time.LocalDateTime;
import java.util.List;

@MetaClass(name = "simiData_TableAndFieldInfo")
public class TableAndFieldInfo extends BaseUuidEntity {
    private static final long serialVersionUID = 2702399623707997297L;

    @MetaProperty
    private TableInfo tableInfo;

    @MetaProperty
    private List<FieldInfo> fields;

    @MetaProperty
    private LocalDateTime catSyncStamp;

    @MetaProperty
    private PostgresDB postgresDB;

    public PostgresDB getPostgresDB() {
        return postgresDB;
    }

    public void setPostgresDB(PostgresDB postgresDB) {
        this.postgresDB = postgresDB;
    }

    public LocalDateTime getCatSyncStamp() {
        return catSyncStamp;
    }

    public void setCatSyncStamp(LocalDateTime catSyncStamp) {
        this.catSyncStamp = catSyncStamp;
    }

    public TableInfo getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }

    public List<FieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<FieldInfo> fields) {
        this.fields = fields;
    }
}