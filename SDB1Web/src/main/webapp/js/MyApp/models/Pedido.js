Ext.define('MyApp.models.Pedido', {
    extend    : 'Ext.data.Model',
    fields   : [
        '_id',
        'codCliente',
        'horario',
        'status'
    ] ,
    proxy: {

        type: 'rest',
        url: '/pedidos'
    }

});
