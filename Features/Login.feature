Feature: Alfardan Login

  Scenario Outline: User Login
#    Given User Launch "<browser>" Browser
#    When User opens URL
#    And User should be navigated to "AFXLOGIN"
    And User enters "CONFIG_AFXUsername" in "Email" field
#    And User enters AFXUsername in "Email" field
#    And User enters "CONFIG_AFXPassword" in "Password" field
#      And User clicks "Sign in"
#      And User clicks "Yes"

    Examples:
      | browser |
      | Chrome  |
