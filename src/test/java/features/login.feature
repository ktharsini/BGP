Feature: LOGIN TO THE BGP

   Scenario: User Login to BGP
   Given User is on Login page and user will login with valid user name password
   When User enter into the new grant
   Then User will apply and proceed to the eligibility
   When User verify the eligibility and faq
   Then User save and proceed
   Given User enter the contact details
   When User verify same as mailing address
   Then User verify same main contact
   Given User enter the proposal
   When User enter business impact
   Then User enter the cost
   Given User declare and review
   When User accept and submit
   Then User logout
  
    