Feature: General Ledger

  Scenario Outline: Add and Post Journal
    Given User Launch "<browser>" Browser
    When User opens URL
    And User enters "<AFXUsername>" in "Email" field
    And User enters "<AFXPassword>" in "Password" field
    And User clicks "LoginButton"
    And User clicks "GeneralledgerNav"
    And User clicks "CategoryQAAddJournal"
    And User enters "<AccountNumberOne>" in "AddAccoutNoone" field
    And User clicks "Addanotherrow"
    And User enters "<AccountNumberTwo>" in "AddAccoutNoTwo" field
    And User clicks "AccountOption"
    And User enters "1" in "DebitOneRow" field
    And User enters "1" in "CreditTwoRow" field
    And User clicks "Savebutton"
    And User gets data from "JournalID"
#    And User sends data into "SearchInputField" input field
    And User clicks "Threedots"
    And User clicks "Viewdetails"
    And User clicks "PostJournalbutton"
    And User clicks "OkPostJournal"
    And User gets data from "PostJournalToast"
    And User assert toast message "<Message>" from "PostJournalToast"
    Examples:
      | browser | AFXUsername | AFXPassword | AccountNumberOne | AccountNumberTwo | Message |
      | Chrome  | IRFAN       | PAssword1   | 1101111001 | 1101111002             | Journal saved successfully! |