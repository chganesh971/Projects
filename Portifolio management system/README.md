#### -- Portfolio Management System

A leading Financial Services Organization wants to strengthen its Middleware by exposing the core logic related to Portfolio Management as Microservices. This middle ware Microservices will be hosted on Cloud so that all the up/downstream applications can get an access to this for performing business transactions.

There will also be a customer Portal to be  developed part of this scope that consumes these Microservices to view their portfolio information and sell their assets.

---

## Overview

---
The __Customer Portal__ displays the [Login page] to the customer. It interacts with the Authorization microservice and provides authorization using JWT.

If the credentials are not available in the in-memory H2 database, It provides with an error message showing "Unable to login. please check your credentials.".

If the uer credentials are correct, it generates a __token__ for the particular session. This token is also provided with an **expiration time**.

Upon succesfully logging in, the user gets redirected to  [Home page] which has options to either see all assets, show the newtworth of the user or the sell any assets

If the user selects [View assets], it redirects to networth page and shows all the assets of the user.

If the user selects [Networth option], it redirects to networth page and shows the networth of the user.

When the user selects [Sell stocks], the list of all the assets are displayed and the user gets to choose his assets to be sold and also the number of units to be sold.After selecting,the portal displays the [updated networth page] along with the stocks sold.


___________________
## Project Details
___________________


### Backend Microservices

1. Daily Share Price
2. Daily Mutual Fund NAV
3. Calculate NetWorth

### Auth Microservice

1. Authentication Microservice


### Frontend Microservices

1. Customer Portal


---
## Backend Microservices
---

 ### 1. Daily Share Price

    Daily Share Price Microservice returns the current market value of the shares.

It is a middleware microservice that contains an in-memory h2 databse which has details about the shares. Once the user gets authorized, this microservice returns the current price of the stock which is present in the database.

---
 ### 2.Daily Mutual Fund NAV

    Daily  Mutual Fund returns the net asset value of each mutual fund.

It is a middleware mirco service that contains an in-memory h2 databse which has details about the mutual funds.Calculate Neworth microservice interacts with this microservice to get the Net asset value.

---

> ### 3. Calculate NetWorth

    It interacts with Daily Share Price and Daily Mutual Fund NAV microservices using feign client to calculate the net worth of a user. 

It retrieves the assets corresponding to the customer portfolio.For each asset, it will interact with both __Daily share price Microservice__  and __Daily Mutual Fund NAV__ to get current market price for that asset and calculate the asset value by multiplying no of units and current market price of the asset.
It will sum all these values to generate networth.

This Microservice has another feature to sell the assets. The user selects the assets to be sold and upon selling, the updated networth is to be calculated and is displayed to the user along with the assets sold.

---
## Auth Microservice
---
### 1.Authorization Microservice

    Authorization Microservice is to authenticate the users.

Authorization microservice gets the user credentials from the Customer portal microservice and validates the users. It creates a token using the Encryption Algorithm and a secret key which is valid for the entire session.

---
## Configuration Microservice

---
## Front-end Microservice
---
### 1.Customer Portal Microservice

It displays networth of user and an option to sell the existing assets of the user

    It interacts with __Calculate Networth__ and __Authorization__ microservices using feign client to calculate the net worth of a user.

It has a MVC architecture and upon successful login, it provides option to user to view the networth and to sell the existing stocks.

***
