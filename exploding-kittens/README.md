# Exploding Kittens (2 Player Version)

### Team Members 
Abishek Goutham and Arpita Ambavane

### Java Version: 17

### Class Diagram
- [ClassDiagram](Class_Diagram_Final.drawio.png)

### Demonstration Video
- [YouTube](https://youtu.be/QoTJck9uyjs)

### Design Patterns used
- Factory
  - Creator: [CardFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/CardFactory.java)
  - ConcreteCreator: [AttackFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/AttackFactory.java), [DefuseFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/DefuseFactory.java), [ExplodingKittensFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/ExplodingKittensFactory.java), [SeeTheFutureFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/SeeTheFutureFactory.java), [ShuffleFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/ShuffleFactory.java), [SkipFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/SkipFactory.java), [StealACardFactory](src/main/java/com/ooad/explodingkittens/model/Card/factory/StealACardFactory.java)
  - Product: [Card](src/main/java/com/ooad/explodingkittens/model/Card/Card.java)
  - ConcreteProduct: [Attack](src/main/java/com/ooad/explodingkittens/model/Card/Attack.java), [Defuse](src/main/java/com/ooad/explodingkittens/model/Card/Defuse.java), [ExplodingKitten](src/main/java/com/ooad/explodingkittens/model/Card/ExplodingKitten.java), [SeeTheFuture](src/main/java/com/ooad/explodingkittens/model/Card/SeeTheFuture.java), [Shuffle](src/main/java/com/ooad/explodingkittens/model/Card/Shuffle.java), [Skip](src/main/java/com/ooad/explodingkittens/model/Card/Skip.java), [StealACard](src/main/java/com/ooad/explodingkittens/model/Card/StealACard.java)
- Strategy
  - Host: [Card](src/main/java/com/ooad/explodingkittens/model/Card/Card.java)
  - Algorithm: [PlayingBehaviour](src/main/java/com/ooad/explodingkittens/model/Card/strategy/PlayingBehaviour.java)
  - Concrete Algorithm: [ChangePlayerAndGiveACard](src/main/java/com/ooad/explodingkittens/model/Card/strategy/ChangePlayerAndGiveACard.java), [EndsTurn](src/main/java/com/ooad/explodingkittens/model/Card/strategy/EndsTurn.java), [MightExplode](src/main/java/com/ooad/explodingkittens/model/Card/strategy/MightExplode.java), [RandomizeDeck](src/main/java/com/ooad/explodingkittens/model/Card/strategy/RandomizeDeck.java), [ShowNextThreeCards](src/main/java/com/ooad/explodingkittens/model/Card/strategy/ShowNextThreeCards.java), [StopExplosion](src/main/java/com/ooad/explodingkittens/model/Card/strategy/StopExplosion.java)
- Command
  - Command Invoker: [Invoker](src/main/java/com/ooad/explodingkittens/command/Invoker.java)
  - Command Interface: [Command](src/main/java/com/ooad/explodingkittens/command/Command.java)
  - Concrete Command: [AttackCommand](src/main/java/com/ooad/explodingkittens/command/AttackCommand.java), [DefuseCommand](src/main/java/com/ooad/explodingkittens/command/DefuseCommand.java), [ExplodingKittensCommand](src/main/java/com/ooad/explodingkittens/command/ExplodingKittensCommand.java), [SeeTheFutureCommand](src/main/java/com/ooad/explodingkittens/command/SeeTheFutureCommand.java), [ShuffleCommand](src/main/java/com/ooad/explodingkittens/command/ShuffleCommand.java), [SkipCommand](src/main/java/com/ooad/explodingkittens/command/SkipCommand.java), [StealACardCommand](src/main/java/com/ooad/explodingkittens/command/StealACardCommand.java)
- MVC
  - Model: [Models](src/main/java/com/ooad/explodingkittens/model)
  - View: [React Application](https://github.com/arpita-ambavane/CSCI5448_ooad_projects/blob/0791fbbc70b10e3b4c53df08b9189385ac76adda/exploding-kittens-client)
  - Controller: [Controllers](src/main/java/com/ooad/explodingkittens/controller)
- Singleton
  - Spring Boot internally uses the Singleton Design Pattern when using the `@Autowired` tag. 
  - SpringBoot Singleton: [GameController](src/main/java/com/ooad/explodingkittens/controller/GameController.java), [PlayerController](src/main/java/com/ooad/explodingkittens/controller/PlayerController.java), [WebSocketController](src/main/java/com/ooad/explodingkittens/controller/WebSocketController.java)
- Iterator
  - We are using the existing `Iterator` module into our code to remove a particular card which was played by the active player. 
  - Iterator: [GameOperations](src/main/java/com/ooad/explodingkittens/model/Game/GameOperations.java) 



### References 
We have not used third-party code so including links referred below resources for different
design elements.
- Overall Design Patterns -
https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns
- Web Socket Implementation - https://www.youtube.com/watch?v=o_IjEDAuo8Y
- Drag and Drop functionality -
  - 1. https://react-dnd.github.io/react-dnd/docs/api/hooks-overview
  - 2. https://react-dnd.github.io/react-dnd/docs/api/use-drag
  - 3. https://react-dnd.github.io/react-dnd/docs/api/use-drop
- Singleton Pattern -https://www.waitingforcode.com/spring-framework/singleton-and-prototype-beans-in-spring-framework/read
- Strategy Pattern - https://refactoring.guru/design-patterns/strategy
- Command Pattern - https://refactoring.guru/design-patterns/command
- Factory Pattern - https://refactoring.guru/design-patterns/strategy

### Instructions to run code 
- Run Backend (this repository) - Confiure Spring and Run 'ExplodingKittensApplication' file. 
- Run Frontend (exploding-kittens-client repo) - Run following commnds to start react application 
    - npm i 
    - npm start
