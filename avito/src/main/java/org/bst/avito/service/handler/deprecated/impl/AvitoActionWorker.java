package org.bst.avito.service.handler.deprecated.impl;

import org.bst.avito.dto.UserDetails;
import org.bst.avito.exceptions.AvitoClassNotFoundException;
import org.bst.avito.service.handler.deprecated.AvitoActionHandler;
import org.bst.avito.service.handler.deprecated.AvitoUserHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * !--------------------------------------------------!
 * Сообщение в будущее.
 * Когда я это писал, я не видел, что у звонков авито нельзя получить такую информацию о пользователе, как chatId и avitoId.
 * По-сути самые бесполезные классы, в какой-то мере они даже немного усложнили работу и оптимизацию, по-этому я помечу их как Deprecated и
 * никогда не буду ими пользоваться.
 * !--------------------------------------------------!
 * Просто оставлю их так, как память о великой абстракции в моей голове!
 */

@Component
@Deprecated
public class AvitoActionWorker {
    private final Map<Class<?>, AvitoActionHandler<?>> avitoActionHandlerMap;

    private final AvitoUserHandler avitoUserHandler;

    public AvitoActionWorker(Map<Class<?>, AvitoActionHandler<?>> avitoActionHandlerMap, AvitoUserHandler avitoUserHandler) {
        this.avitoActionHandlerMap = avitoActionHandlerMap;
        this.avitoUserHandler = avitoUserHandler;
    }

    @SuppressWarnings("unchecked")
    public <T> void handle(List<T> elements) {
        if (elements.isEmpty()) {
            return;
        }

        Class<?> clazz = elements.get(0).getClass();
        AvitoActionHandler<T> avitoActionHandler = (AvitoActionHandler<T>) avitoActionHandlerMap.get(clazz);

        if (avitoActionHandler == null) {
            throw new AvitoClassNotFoundException("Handle class not found");
        }

        List<UserDetails> userDetails = avitoActionHandler.toUserDetails(elements);

        for (UserDetails userDetail : userDetails) {
            avitoUserHandler.handle(userDetail);
        }
    }
}
