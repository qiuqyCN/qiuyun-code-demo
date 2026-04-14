package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

import java.util.function.Supplier;

public interface FunctionalGUIFactory {
    Supplier<Button> getButtonSupplier();
    Supplier<Checkbox> getCheckboxSupplier();
    Supplier<TextField> getTextFieldSupplier();
}
