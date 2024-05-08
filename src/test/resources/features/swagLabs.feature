@all
  Feature: process checkout on swag labs and login
    @checkout
    Scenario: process login until checkout with happy path
      Given user direct to swag labs
      When user on swag labs user login with valid credential
      And user click button login
      Then user success login into swag labs "Products"
      And user shorting current product from Z-A
      Then display product "Sauce Labs Onesie" on top list
      And user Select first product on list of products
      And user open menu checkout
      Then display the product that checkouted "Sauce Labs Onesie"
      And user checkout item
      And user input firstname "irfan"
      And user input lastname "azhar"
      And user input postal code "17112"
      And user click button continue
      And user click button finish on overview
      Then user will get info success order "Thank you for your order!"

      @lockeduser
      Scenario: failed login due to locked user
        Given user direct to swag labs
        When user on swag labs user login with locked user credential
        And user click button login
        Then user failed login and display message "Epic sadface: Sorry, this user has been locked out."


      @notMatchCredential
      Scenario: failed login due to not match credential
        Given user direct to swag labs
        When user on swag labs user login with not match credential
        And user click button login
        Then user failed login and display message "Epic sadface: Username and password do not match any user in this service"







