# Event-Driven-Architecture : 

### Dependencies : 
```xml
<dependency>
            <groupId>org.axonframework</groupId>
            <artifactId>axon-spring-boot-starter</artifactId>
            <version>4.4.3</version>
            <exclusions>
                <exclusion>
                    <groupId>org.axonframework</groupId>
                    <artifactId>axon-server-connector</artifactId>
                </exclusion>
            </exclusions>
```

### Classes : 
#### Abstract Class : 
  ```java
public abstract class BaseCommand <T>{
    @TargetAggregateIdentifier
    private T id;
 ```
  
##### @TargetAggregateIdentifier :  
Pour identifer le target sur lequel on va effectuer la commande


  ```java
public class CreateAccountCommand extends BaseCommand<String>{
private double initialBalance;
private String currency;

    public CreateAccountCommand(String id, double initialBalance, String currency) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }
}

  ```
 ```java
public class CreditAccountCommand extends BaseCommand<String>{
private double amount;
private String currency;

    public CreditAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
 ```
 ```java
public class DebitAccountCommand extends BaseCommand<String>{
private double amount;
private String currency;

    public DebitAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
 ```
 ```java
@RestController
@RequestMapping(path="/commands/account")
@AllArgsConstructor
public class AccountCommandController {
private CommandGateway commandGateway;
@PostMapping(path="/create")
public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO request){
CompletableFuture<String> commandResponse=commandGateway.send(new CreateAccountCommand(
UUID.randomUUID().toString(),
request.getInitialBalance(),
request.getCurrency()
));
return commandResponse;
}
}
 ```

