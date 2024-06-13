package com.company.bstcrm.service;

import com.company.bstcrm.dto.ClientClaimAvitoDTO;
import com.company.bstcrm.entity.Client;
import com.company.bstcrm.entity.ClientClaim;
import com.company.bstcrm.entity.ClientClaimState;
import com.company.bstcrm.entity.User;
import io.jmix.core.DataManager;
import org.springframework.stereotype.Service;

@Service("clientClaimService")
public class ClientClaimService {

    private final DataManager dataManager;

    public ClientClaimService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void createClaim(ClientClaimAvitoDTO clientClaimAvitoDTO) {
        Client client = dataManager.create(Client.class);
        client.setContact(clientClaimAvitoDTO.getContact());
        client.setName(clientClaimAvitoDTO.getName());

        client = dataManager.save(client);

        ClientClaim request = dataManager.create(ClientClaim.class);

        request.setClient(client);
        request.setClientClaimState(ClientClaimState.NEW);
        request.setContacts(clientClaimAvitoDTO.getContact());
        request.setName(clientClaimAvitoDTO.getAdvertName());
        request.setUser(dataManager.load(User.class).id(clientClaimAvitoDTO.getEmployeeId()).one());

        dataManager.save(request);
    }
}
