Feature: Alfardan Login

  Scenario Outline: Cashier apply for LC transfer under foreign currency
    Given User Launch "<browser>" Browser
    When User opens URL
#    And User should be navigated to "AFXLOGIN"
    And User enters "<AFXUsername>" in "Email" field
    And User enters "<AFXPassword>" in "Password" field
    And User clicks "LoginButton"
    And User clicks "Remittance"
    And User clicks "ForeignCurrency"
    And User clicks "Lctransfer"
    And User clicks "Lctransferbutton"
    And User clicks "transfertypedropdown"
    And User clicks "transfertypedropdownoption"
    And User clicks "cashiernamedropdown"
    And User clicks "cashiernamedropdownoption"
    And User enters "<Amount>" in "Amountinput" field
    And User clicks "LCtransfersubmitbutton"
    Examples:
      | browser | AFXUsername | AFXPassword | Amount |
      | Chrome  | IRFAN       | PAssword1   | 11     |

#  Scenario Outline: User creation under user management
#    Given User clicks "SetUpTab"
#    And User clicks "Usermanagement"
#    And User clicks "AddUserbutton"
#    And User enters "<FirstName>" in "UserfirstName" field
#    And User enters "<ShortName>" in "UserShortName" field
#    Examples:
#      | browser | ShortName | FirstName | Amount |
#      | Chrome  | User       | Anonymous   | 11     |
