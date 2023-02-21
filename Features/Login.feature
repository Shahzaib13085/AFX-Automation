Feature: Alfardan Login

  Scenario Outline: User Login
    Given User Launch "<browser>" Browser
    When User opens URL
#    And User should be navigated to "AFXLOGIN"
    And User enters "<AFXUsername>" in "Email" field
    And User enters "<AFXPassword>" in "Password" field
    And User clicks "LoginButton"

    Examples:
      | browser |AFXUsername|AFXPassword|
      | Chrome  |IRFAN      |PAssword1  |
