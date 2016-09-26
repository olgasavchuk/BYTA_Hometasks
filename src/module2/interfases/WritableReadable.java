package module2.interfases;

import module2.models.Bouquet;

import java.util.Objects;

public interface WritableReadable {
    void writeToSource(Bouquet bouquet, Object... arguments);
    void readFromSource();
}
