package org.bst.avito.service.handler.deprecated;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
@Service
public class AvitoActionHandlerMap {
    private final List<AvitoActionHandler<?>> avitoActionHandlers;

    public AvitoActionHandlerMap(List<AvitoActionHandler<?>> avitoActionHandlers) {
        this.avitoActionHandlers = avitoActionHandlers;
    }

    @Bean
    public Map<Class<?>, AvitoActionHandler<?>> actionHandlerMap() {
        Map<Class<?>, AvitoActionHandler<?>> actionHandlerMap = new HashMap<>();

        for (AvitoActionHandler<?> avitoActionHandler : avitoActionHandlers) {
            actionHandlerMap.put(avitoActionHandler.getClassHandled(), avitoActionHandler);
        }

        return actionHandlerMap;
    }
}
