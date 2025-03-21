# Custom Developments

- CopyDataProductBean
   - deep copy of some DataProducts
   - **List<Function<E, List<? extends StandardEntity>>>**
- StyleUploadDownloadBean
   - upload and check version of .qml
   - **void handleFileUploadSucceed(FileUploadField uploadField, Consumer<String> assignResult)** Kann das auch "String handleFileUploadSucceed(FileUploadField uploadField)" sein?
- PostgresTableEdit
   - read json in SchemaReaderBean
   - generate TableFields from read data and update catSynced
- PubScopeFragment
   - set default value in onInitEntity
   - programmatically add JpqlCondition
- FilterFragment
   - simple filter functionality for browse screens
- DataProductBrowse
   - create PropertiesInList / PropertiesInFacade joining entities when edit screen closes. **Verstehe / finde ich nicht...**
   - use *remove* action to properly remove joining entities. **Verstehe / finde ich nicht...**
- LayerGroupEdit / FacadeLayerEdit
   - convert FL to LG
- Sort on table in FacadeLayerEdit, LayerGroupEdit, MapEdit and TableViewEdit
  - **In Bean extrahieren.** Zum Beispiels mittels Interface SortFieldEntity und Interfacemethode getSortField() oder ähnlich.
- RasterViewEdit / TableViewEdit
   - create new Permission entity and add it directly to the table within the current edit screen
- PostgresDBBrowse
   - check if DB is empty before deleting it
- PostgresTableBrowse
   - initializer and afterCloseListener for TableViewEdit Screen
   - generated columns to show related TableViews
- Custom validator
   - TableViewEdit for searchFilterWordField
   - FeatureInfoEdit for pyModuleNameField and sqlQueryField
   
   
**Allgemein**
- Exception Messages: 
  - Entweder hardcodiert englisch oder in *.properties deutsch
  - Ersatz der Konkatenierungen durch Verwendung von MessageFormat.format(). (Für Nachricht-Strings mit Parametern)
  - In ganzer codebasis suchen nach "Exception(", damit sollten die meisten Fälle gefunden werden.

