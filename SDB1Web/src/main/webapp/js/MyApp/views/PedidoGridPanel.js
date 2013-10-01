Ext.define('MyApp.views.PedidoGridPanel', {
    extend   : 'Ext.grid.Panel',
    alias    : 'widget.PedidoGridPanel',
    requires : ['MyApp.stores.PedidoStore'],

    initComponent : function() {
        this.store   = MyApp.stores.PedidoStore;
        this.columns = this.buildColumns();
        this.callParent();
    },
    buildColumns : function() {
        return [
            {
                header    : 'ID',
                dataIndex : '_id',
                width     : 70
            },
            {
                header    : 'Cod Cliente',
                dataIndex : 'codCliente',
                width     : 70
            },
            {
                header    : 'Status',
                dataIndex : 'status',
                width     : 70
            },
            {
                header    : 'Horário',
                dataIndex : 'horario',
                width     : 70
            }
        ];
    }
});
