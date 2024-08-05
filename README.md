# GitHub API

This application provides an API to list all non-fork GitHub repositories for a given user along with their branches and the last commit SHA for each branch.

## Prerequisites

- Java 21
- Maven
- GitHub Personal Access Token

## Setting Up

### 1. Clone the Repository
```bash
git clone https://github.com/Xayanix/Atipera.git
```
### 2. Setup access token in application.properties
```bash
github.token=TOKEN
```
### 3. Build and Run the Application
```bash
mvn spring-boot:run
```
