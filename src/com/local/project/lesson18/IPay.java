package com.local.project.lesson18;

@FunctionalInterface
public interface IPay {
    boolean pay(int amaunt);

    default IPay additionalPay(IPay another) {
        return (amaunt) -> {
            if (!pay(amaunt))
                return another.pay(amaunt);
            return true;
        };
    }
}
// Interface: IPay
// абстрактный boolean pay();
// default метод IPay additionalPay(IPay pay)
// альтернативный способ используется,
// если предыдущий не сработал
