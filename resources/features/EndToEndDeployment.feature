@EndToEndDeployment
Feature: CNet Global EndToEndDeployment Scenario

  @EndToEndDeploymentFlow
  Scenario Outline: EndToEndDeployment
    Given Launch Browser and Navigate to CNet URL
    Then Switch to MainFrame
    And Verify whether Login page is correctly opened or not
    When Enter Username and Password as "<Username>" and "<Password>"
    Then Verify whether Home page is correctly opened or not
    When Enter Value in Filter Navigation Field Text Box "<FilterValue>"
    And Click on Service Catalog Order Guides Link
    Then Switch to MainFrame
    When Click on End To End Deployment
    Then Verify whether Try It button is enabled or not
    When Click on Try It
    #Then Verify whether Describe Needs page is getting displayed or not
    #And Click On Project LookUP
    #Then Switch to Multiple Window and Select Text as "<Project>"
    #Then Switch to MainFrame
    #When Select Environment Information as "<EnvironmentInformation>"
    #When Select Type of Environment as "<TypeOfEnvironment>"
    #/ When Select Environment Name as "<EnvironmentName>" 
    #When Click On Cloud Platform
    #Then Switch to Multiple Window and Select Text as "<CloudPlatform>"
    #Then Switch to MainFrame
    #When Select Existing Key Pair Checkbox
    #When Click On Select Key Pair
    #Then Switch to Multiple Window and Select Text as "<KeyPair>"
    #Then Switch to MainFrame
    #When Select WebServer Checkbox
    #When Select Webserver Type as "<WebserverType>"
    #When Select Container Platform as "<ContainerPlatform>"
    #When Select Application Type as "<ApplicationType>"
    #When Select Database Server Checkbox
    #When Select Database Type as "<DatabaseType>"
    #When Select Database Container Platform as "<DatabaseContainerPlatform>"
    #And Click on Choose Options
    #Then Verify whether Choose Options page is getting displayed or not
    #When Click On Server Requested LookUP
    #Then Switch to Multiple Window and Select Text as "<ServerRequested>"
    #Then Switch to MainFrame
    #When Enter Cluster Name as "<ClusterName>"
    #When Select Existing Network Checkbox
    #When Click On Select Network
    #Then Switch to Multiple Window and Select Text as "<SelectNetwork>"
    #Then Switch to MainFrame
    #When Select Security Group Checkbox
    #When Click On Security Group
    #Then Switch to Multiple Window and Select Text as "<SecurityGroup>"
    #Then Switch to MainFrame
    #When Click On Operating System LookUP
    #Then Switch to Multiple Window and Select Text as "<OperatingSystem>"
    #Then Switch to MainFrame
    #When Click On Server Size LookUP
    #Then Switch to Multiple Window and Select Text as "<ServerSize>"
    #Then Switch to MainFrame
    #When Click On Next Tab
    #When Click On Database Service Requested LookUP
    #Then Switch to Multiple Window and Select Text as "<DatabaseServiceRequested>"
    #Then Switch to MainFrame
    #When Enter Database Cluster Name as "<DatabaseClusterName>"
    #When Select Database Network Configuration Checkbox
    #When Click On Database Network Configuration Group
    #Then Switch to Multiple Window and Select Text as "<DatabaseNetworkConfiguration>"
    #Then Switch to MainFrame
    #When Select Database Security Group Checkbox
    #When Click On Database Security Group
    #Then Switch to Multiple Window and Select Text as "<DatabaseSecurity>"
    #Then Switch to MainFrame
    #When Click On Database Operating System LookUP
    #Then Switch to Multiple Window and Select Text as "<DatabaseOperatingSystem>"
    #Then Switch to MainFrame
    #When Click On Next Tab
    #When Click On Check Out
    #Then Verify whether Shopping Cart page is getting displayed or not
    #When Click on Order Now
    #Then Validate Successful Message is displayed or not
    #When Get the Request Number after created
    #Then Click On Recently Created Requested Number
    #When Click on RITM Numbers and Approve all RITM Numbers for the Request Created
    #Then Switch to Multiple Window
    #When Search Request in a CMDB Table as "<CMDBTable>"
    #When Click on User Menu Dropdown
    #And Click on Logout

    Examples: 
      | Username  | Password | FilterValue                    | Project    | EnvironmentInformation   | TypeOfEnvironment | EnvironmentName  | CloudPlatform | KeyPair |  | WebserverType | ContainerPlatform | ApplicationType | DatabaseType | DatabaseContainerPlatform | ServerRequested | ClusterName  | SelectNetwork | SecurityGroup | OperatingSystem | ServerSize | DatabaseServiceRequested | DatabaseClusterName | DatabaseNetworkConfiguration | DatabaseSecurity | DatabaseOperatingSystem | CMDBTable           |
      | test.user | test     | Order Guides | PRJ0010001 | Create Environment - New | Development       | Environment Name | AWS_New York  | qa      |  | Yes           | Kubernetes        | JAVA            | Yes          | Kubernetes                | Weblogic        | Cluster Name | vpc-f7c3d993  | (empty)       | RHEL 7          | t2.medium  | Oracle                   | Cluster Name        | vpc-f7c3d993                 | (empty)          | RHEL 7                  | cmdb_ci_server.list |

 