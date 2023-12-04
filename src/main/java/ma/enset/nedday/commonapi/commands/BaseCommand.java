package ma.enset.nedday.commonapi.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand <T>{
    @TargetAggregateIdentifier
    private T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}
