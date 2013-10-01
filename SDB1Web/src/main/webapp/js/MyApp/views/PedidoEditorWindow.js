Ext.define('MyApp.views.PedidoEditorWindow', {
    extend   : 'Ext.Window',
    requires : ['MyApp.views.PedidoGridPanel','MyApp.views.PedidoFormPanel'],

    height : 500,
    width  : 600,
    border : false,
    layout : {
        type  : 'hbox',
        align : 'stretch'
    },

    initComponent : function() {
        this.items   = this.buildItems();
        this.buttons = this.buildButtons();
        this.callParent();

        this.on('afterrender', this.onAfterRenderLoadForm, this);
    },
    buildItems : function() {
        return [
            {
                xtype     : 'PedidoGridPanel',
                width     : 280,
                itemId    : 'pedidoGrid',
                listeners : {
                    scope     : this,
                    itemclick : this.onGridItemClick
                }
            },
            {
                xtype  : 'PedidoFormPanel',
                itemId : 'pedidoForm',
                flex   : 1
            }
        ];
    },
    buildButtons : function() {
        return [
            {
                text    : 'Save',
                scope   : this,
                handler : this.onSaveBtn
            },
            {
                text    : 'New',
                scope   : this,
                handler : this.onNewBtn
            }
        ];
    },
    onGridItemClick : function(view, record) {
        var formPanel = this.getComponent('pedidoForm');
        formPanel.loadRecord(record)
    },
    onSaveBtn : function() {
        var gridPanel  = this.getComponent('pedidoGrid'),
            gridStore  = gridPanel.getStore(),
            formPanel  = this.getComponent('pedidoForm'),
            basicForm  = formPanel.getForm(),
            currentRec = basicForm.getRecord(),
            formData   = basicForm.getValues(),
            storeIndex = gridStore.indexOf(currentRec),
            key;

        //loop through the record and set values
        currentRec.beginEdit();
        for (key in formData) {
            currentRec.set(key, formData[key]);
        }
        currentRec.endEdit();
        currentRec.commit();

        // Add and select
        if (storeIndex == -1) {
            gridStore.add(currentRec);
            gridPanel.getSelectionModel().select(currentRec)
        }
    },
    onNewBtn : function() {
        var gridPanel = this.getComponent('pedidoGrid'),
            formPanel = this.getComponent('pedidoForm'),
            newModel  = Ext.ModelManager.create({}, 'MyApp.models.Pedido');

        gridPanel.getSelectionModel().clearSelections();
        formPanel.getForm().loadRecord(newModel)
    },
    onAfterRenderLoadForm : function() {
        this.onNewBtn();
    }
});
