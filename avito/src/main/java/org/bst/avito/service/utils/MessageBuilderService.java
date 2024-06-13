package org.bst.avito.service.utils;

import org.bst.avito.entity.EmployeeEntity;
import org.bst.avito.service.EmployeeQueue;
import org.springframework.stereotype.Service;

@Service
public class MessageBuilderService {
    private final EmployeeQueue employeeQueue;

    public MessageBuilderService(EmployeeQueue employeeQueue) {
        this.employeeQueue = employeeQueue;
    }

    public String getFirstMessage(EmployeeEntity employeeEntity) {
        StringBuilder stringBuilder = new StringBuilder();

        String textToSend = "Добро пожаловать в чат компании БСТ! \n" +
                "Наш менеджер ответит вам при первой же возможности :) \n" +
                "Для более быстрого ответа рекомендуем позвонить по номеру в объявлении \n";

        stringBuilder.append(textToSend);

        stringBuilder.append(employeeEntity.getName() + " - " + employeeEntity.getPhoneNumber());

        return stringBuilder.toString();
    }

    public String getNewMessage(EmployeeEntity employeeEntity) {
        StringBuilder stringBuilder = new StringBuilder();

        String textToSend = "Спасибо, что снова обратились к нам! \n" +
                "Менеджер, работавший с вами уже спешит помочь вам! \n" +
                "Для более быстрого ответа вы можете ему позвонить :) \n";

        stringBuilder.append(textToSend);

        stringBuilder.append(employeeEntity.getName() + " - " + employeeEntity.getPhoneNumber());

        return stringBuilder.toString();
    }
}
