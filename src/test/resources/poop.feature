Feature: the poop can be retrieved
  Scenario: client makes call to GET /cucumber
    When the client calls /cucumber
    Then the client receives status code of 200
    And the client receives server version Success