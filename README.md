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

## Example API response
```bash
[
    {
        "name": "Atipera",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "main",
                "commit": {
                    "sha": "d47b699a51a95d08e8d9a6b8208972be8cbae103"
                }
            }
        ],
        "fork": false
    },
    {
        "name": "BringBackChatEdit",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "main",
                "commit": {
                    "sha": "058a6790cb236256f11f400cc29b041ec6ef0471"
                }
            }
        ],
        "fork": false
    },
    {
        "name": "CrackAllower",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "6e5b78ba94ff82fdf3295cc0beaa03bcdc62d265"
                }
            }
        ],
        "fork": false
    },
    {
        "name": "MC-MultiLang-API",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "main",
                "commit": {
                    "sha": "68b74449885d72512415d32b54d8f7bd231a1f1f"
                }
            }
        ],
        "fork": false
    },
    {
        "name": "McList.pl",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "5a905df1c2a6774e3bdf1f34ab89f92b7775db27"
                }
            }
        ],
        "fork": false
    },
    {
        "name": "OrderServiceAPI",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "e6d3dcf46598a971590bc1ab1660c244f0b85b03"
                }
            }
        ],
        "fork": false
    },
    {
        "name": "RenewBlocks",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "56c8ab44edd2b3205615980627eb7a7619d407de"
                }
            }
        ],
        "fork": false
    },
    {
        "name": "WorldServerLeakFix",
        "owner": {
            "login": "Xayanix"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "baf2b154d3c6a8c22ed30cb37ca67f0db96394c7"
                }
            }
        ],
        "fork": false
    }
]
```
