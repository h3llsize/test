package com.company.bstcrm.view.client;

import com.company.bstcrm.entity.Client;

import com.company.bstcrm.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "clients", layout = MainView.class)
@ViewController("Client.list")
@ViewDescriptor("client-list-view.xml")
@LookupComponent("clientsDataGrid")
@DialogMode(width = "64em")
public class ClientListView extends StandardListView<Client> {
}