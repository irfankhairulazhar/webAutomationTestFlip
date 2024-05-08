@flip @main @test

  Feature: flip landing page
    Scenario: change and verify language
      Given user direct to flip landing page
      When user on flip page change language to en
      Then all wordings using english "Free financial transactions, to anyone."
      And user change back the language to id
      Then all wordings using english "Bebas transaksi, ke siapa aja."

      @provider
      Scenario: mobile phone credit or package
        Given user direct to flip landing page
        When user on flip page scroll down to digital product
        And user click button learn more
        Then user will see icon provider

#        please check currenr kurs GBP and change the string of then on line 27
        @remittance
        Scenario: remittance transaction
          Given user direct to flip landing page
          When user on flip page open product
          And user open flip globe
          And user input currency "GBP"
          And user input idr amount "1000000"
#          Then display GBP amount "49.08"
          Then display current kurs rate GBP "1 GBP = 20.185,35 IDR"
          Then display service fee "0 IDR"
          Then display total payment "1.000.000 IDR"











