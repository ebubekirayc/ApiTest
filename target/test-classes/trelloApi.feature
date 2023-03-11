@trelloApi
Feature: Kullanıcı Trello API uzerinde cesitli islemler yapabilmelidir
  Background: Kullanıcı Base URL i setler
    Given Kullanıcı Trello icin Base URL set eder "https://api.trello.com"
     #Bu scen. de bizler board create edeceğiz ayrıca taskımıza bizlere verilen
    # diğer işlemleri gerçekleştirebilmek için bizlerin board id sine ihtiyacı vardır
    #Board ıd yi de bu scen. alabacağız. Ve Boardun create edildiğini assert edeceğiz.    ------->>>>>>>>>< class seviyesinde tanımla

# URL = https://trello.com/login ve https://trello.com/app-key
 @createboard
  Scenario: Kullanıcı board create edebilmeli
    When Kullanıcı board create edebilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar "idPath","1","boardsPath","boards"
    And Kullanıcı board id yi alır
    Then Kullanıcı boad un basarili bir sekilde create edildigini dogrular

  #
  @createCard
Scenario: Kullanıcı card create edebilmek için list create edebilmeli
    When Kullanıcı list create edebilmek için ilgili url e POST methodu ile request atar "idPath","1","listsPath","lists"
    And Kullanıcı list idi yi alir
    Then Kullanıcı listin basari ile create edildiğini verfiy eder