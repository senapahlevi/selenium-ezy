Feature: CheckClaim
  @CheckClaim
  Scenario: CheckClaim
    Given User is already on homepage
    When User fill registration number
    And User Click Claim Check Button
    Then User verify data claim

