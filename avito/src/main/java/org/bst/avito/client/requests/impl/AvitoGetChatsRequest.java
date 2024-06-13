package org.bst.avito.client.requests.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.bst.avito.client.requests.AvitoGetRequest;

import java.util.List;

@Data
@Builder
public class AvitoGetChatsRequest implements AvitoGetRequest {

    @JsonProperty("item_ids")
    private String itemIds;

    @JsonProperty("unread_only")
    private Boolean unreadOnly;

    @JsonProperty("chat_types")
    private String chatTypes;

    private Long limit;

    private Long offset;

    @Override
    public String getMethodPath() {
        return "/messenger/v2/accounts/USER_ID/chats";
    }

    public void setChatTypes(Boolean isAds) {
        if(isAds)
            this.chatTypes = "u2i";
        else
            this.chatTypes = "u2u";
    }

    public void setItemIds(List<String> itemIds) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < itemIds.size() - 1; i++) {
            stringBuilder.append(itemIds.get(i));
            stringBuilder.append(",");
        }
        stringBuilder.append(itemIds.get(itemIds.size() - 1));

        this.itemIds = stringBuilder.toString();
    }
}
