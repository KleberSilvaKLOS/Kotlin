Os Objetos anônimos (ou Object Expressions) são uma mão na roda no Kotlin. Eles servem para quando você precisa criar um objeto que implementa uma interface ou estende uma classe, mas você não quer criar um arquivo novo ou dar um nome para essa classe, porque só vai usá-la uma única vez ali no código.

Em vez de declarar "class MeuLog: Notificavel", você cria o objeto "on-the-fly" (na hora)