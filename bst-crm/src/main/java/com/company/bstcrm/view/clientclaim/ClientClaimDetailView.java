package com.company.bstcrm.view.clientclaim;

import com.company.bstcrm.entity.ClientClaim;

import com.company.bstcrm.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "clientClaimsEdit/:id", layout = MainView.class)
@ViewController("ClientClaim.detail")
@ViewDescriptor("client-claim-detail-view.xml")
@EditedEntityContainer("clientClaimDc")
public class ClientClaimDetailView extends StandardDetailView<ClientClaim> {
}