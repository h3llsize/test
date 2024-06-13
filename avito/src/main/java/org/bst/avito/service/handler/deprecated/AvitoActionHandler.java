package org.bst.avito.service.handler.deprecated;

import jakarta.persistence.MappedSuperclass;
import org.bst.avito.dto.UserDetails;
import org.bst.avito.service.utils.GenericInfo;

import java.util.List;

@Deprecated
@MappedSuperclass
public interface AvitoActionHandler<T> {
    default Class<?> getClassHandled() {
        return GenericInfo.getGenericType(getClass());
    }

     List<UserDetails> toUserDetails(List<T> actionList);
}
