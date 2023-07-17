package com.example.app_bank1.other_paymens.categories.controller;



/**
 * Исключение, выбрасываемое, когда сущность не найдена.
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Конструктор с параметром для создания объекта EntityNotFoundException.
     *
     * @param message сообщение об ошибке
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
