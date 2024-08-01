Feature: DCS ou CCS desacoplado é um produto que foi criado para permitir a comunicação bidirecional
  entre o issuer e o holder de forma desacoplada do fluxo padrão de comunicação já existente no contexto de fraude, via CCS da FICO.

     Scenario Outline: Validar Adição de Mais campos para o placeHolders

       Given Todas as informações de Payload OK
       When Com a chave <placeholders> vazia
       Then Processar e estabelecer a comunicação com o falcon passando as informações.
       Examples:
        |placeholders| " "|

