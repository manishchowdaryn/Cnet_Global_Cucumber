@EndToEndDeployment
Feature: CNet Global EndToEndDeployment Scenario

  @EndToEndDeployment
  Scenario Outline: EndToEndDeployment
    Given Launch Browser and Navigate to CNet URL
    Then Switch to MainFrame
    And Verify whether Login page is correctly opened or not
    When Enter Username and Password as "<Username>" and "<Password>"
    Then Verify whether Home page is correctly opened or not
    #When Enter Value in Filter Navigation Field Text Box "Service Catalog - Order Guides"
    #And Click on Service Catalog Order Guides Link
    #Then Switch to MainFrame
    #When Click on End To End Deployment
    #When Click on Try It
    #And Click On Project LookUP
    #Then Switch to Multiple Window and Select Text as "PRJ0010001"
    #Then Switch to MainFrame
    #When Select Environment Information as "Create Environment - New"
    #When Select Type of Environment as "Development"
    #When Select Environment Name as "Environment Name"
    #When Click On Cloud Platform
    #Then Switch to Multiple Window and Select Text as "AWS_New York"
    #Then Switch to MainFrame
    #When Select Existing Key Pair Checkbox
    #When Click On Select Key Pair
    #Then Switch to Multiple Window and Select Text as "qa"
    #Then Switch to MainFrame
    #When Select WebServer Checkbox
    #When Select Webserver Type as "Yes"
    #When Select Container Platform as "Kubernetes"
    #When Select Application Type as "JAVA"
    #When Select Database Server Checkbox
    #When Select Database Type as "Yes"
    #When Select Database Container Platform as "Kubernetes"
    #And Click on Choose Options
    #When Click On Server Requested LookUP
    #Then Switch to Multiple Window and Select Text as "Weblogic"
    #Then Switch to MainFrame
    #When Enter Cluster Name as "Cluster Name"
    #When Select Existing Network Checkbox
    #When Click On Select Network
    #Then Switch to Multiple Window and Select Text as "vpc-f7c3d993"
    #Then Switch to MainFrame
    #When Select Security Group Checkbox
    #When Click On Security Group
    #Then Switch to Multiple Window and Select Text as "(empty)"
    #Then Switch to MainFrame
    #When Click On Operating System LookUP
    #Then Switch to Multiple Window and Select Text as "RHEL 7"
    #Then Switch to MainFrame
    #When Click On Server Size LookUP
    #Then Switch to Multiple Window and Select Text as "t2.medium"
    #Then Switch to MainFrame
    #When Click On Next Tab 
    #When Click On Database Service Requested LookUP
    #Then Switch to Multiple Window and Select Text as "Oracle"
    #Then Switch to MainFrame
    #When Enter Database Cluster Name as "Cluster Name"
    #When Select Database Network Configuration Checkbox
    #When Click On Database Network Configuration Group
    #Then Switch to Multiple Window and Select Text as "vpc-f7c3d993"
    #Then Switch to MainFrame
    #When Select Database Security Group Checkbox
    #When Click On Database Security Group
    #Then Switch to Multiple Window and Select Text as "(empty)"
    #Then Switch to MainFrame
    #When Click On Database Operating System LookUP
    #Then Switch to Multiple Window and Select Text as "RHEL 7"
    #Then Switch to MainFrame
    #When Click On Next Tab
    #When Click On Check Out
    #When Click on Order Now
    #Then Validate Successful Message is displayed or not
    #When Get the Request Number after created
    #Then Click On Recently Created Requested Number
    #When Click on RITM Numbers and Approve all RITM Numbers for the Request Created
    #Then Switch to Multiple Window
    #When Search Request in a CMDB Table as "cmdb_ci_server.list"
    #When Click on User Menu Dropdown
    #And Click on Logout
    

    Examples: 
      | Username  |  | Password |
      | test.user |  | test1     |
