

Ext.define('MyApp.views.PedidoFormPanel', {
    extend      : 'Ext.form.Panel',
    alias       : 'widget.PedidoFormPanel',
    requires : ['MyApp.stores.PedidoStore'],

    bodyStyle   : 'padding: 10px; background-color: #DCE5F0; border-left: none;',
    defaultType : 'textfield',
    defaults    : {
        anchor     : '-10',
        labelWidth : 70
    },

    initComponent : function() {
        this.items = this.buildItems();

        this.callParent();
    },
    buildItems : function() {
        return [
            {
                fieldLabel : 'ID',
                name       : '_id'
            },
            {
                fieldLabel : 'Cod Cliente',
                name       : 'codCliente'


            },
            {
                fieldLabel : 'Status',
                name       : 'status'
            },
            {
                fieldLabel : 'Horario',
                name       : 'horario'

            }
        ];
    },
    buttons: [{
        text: 'Submit',
        handler: function(){
            MyApp.stores.PedidoStore.save();
        }
    }]
});

