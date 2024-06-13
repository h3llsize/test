package com.company.bstcrm.view.clientclaim;

import com.company.bstcrm.entity.ClientClaim;

import com.company.bstcrm.entity.ClientClaimState;
import com.company.bstcrm.service.UserService;
import com.company.bstcrm.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.time.OffsetDateTime;
import java.util.concurrent.TimeUnit;

@Route(value = "clientClaims", layout = MainView.class)
@ViewController("ClientClaim.list")
@ViewDescriptor("client-claim-list-view.xml")
@LookupComponent("clientClaimsDataGrid")
@DialogMode(width = "64em")
public class ClientClaimListView extends StandardListView<ClientClaim> {
    @ViewComponent
    private DataGrid<ClientClaim> clientClaimsDataGrid;
    @Autowired
    private UserService userService;

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        clientClaimsDataGrid.addClassName("styling");

        clientClaimsDataGrid.setPartNameGenerator(clientClaim -> {
            if(clientClaim.getLastModifiedDate().isBefore(OffsetDateTime.now().minus(24, TimeUnit.HOURS.toChronoUnit())) &&
                    (clientClaim.getClientClaimState() == ClientClaimState.IN_PROCESS || clientClaim.getClientClaimState() == ClientClaimState.THINKING)) {
                return "red";
            }

            if(clientClaim.getClientClaimState() == ClientClaimState.IN_PROCESS || clientClaim.getClientClaimState() == ClientClaimState.THINKING)
                return "yellow";

            if(clientClaim.getClientClaimState() == ClientClaimState.CANCELED)
                return "red";

            if(clientClaim.getClientClaimState() == ClientClaimState.NEW && clientClaim.getCreatedDate().
                    isBefore(OffsetDateTime.now().minus(1, TimeUnit.HOURS.toChronoUnit())))
                return "red";

            return "green";
        });
    }
}