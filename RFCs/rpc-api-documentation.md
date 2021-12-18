# RPC API Documentation

This documentation regulates the APIs for RPC (Remote Procedure Call).

```javascript
const BASE_URL = `https://localhost:8080`;
const API_URL = `${BASE_URL}/api/`;
```

All request after logged in with credentials.

## Authentication

### Login

```javascript
// method: POST
// url: ${API_URL}/login
const req = 
{
  "username": "",
  "password": "",
}
const resp = 
{
    "success": true,
    "message“: “  ”,
    "content": {
        "userId": "Admin001",
        "firstName": "Admin",
        "lastName": "1",
        "phoneNum":12345674 ,
        "isAdmin": 1,
        "token": "XMUMG6"
    }
}
```
### sign out
```javascript
// method: POST
// url: 
const req =
    {
      
    }
const resp =
    {
        
        }
    }

## Get data

### GetRoomList

Get RoomList with 

```javascript
// method: GET
// url: ${API_URL}/getRoomList
const req=
    {
        
    }
  const resp =
      {
         "content": 
          
      }    
    


```

### GetMyReservation

Get Reservations registered under current user

```javascript
// method: GET
// url: ${API_URL}/getMyReservation

const resp =
{

}
```



## Make reservation

```javascript
// method: POST
// url: ${API_URL}/makeReservation
const req = 
{
  "user": userObj,
  "roomID": "",
  "members": List,
  "start": datetime,
  "end": datetime,
}
const resp =
{
  "success": int,
  "message": "",
}
```
## Delete my reservation
```javascript
// method: Delete
// url: 
const req = 
{

}
const resp =
{
  
}
```
## get Reservation information list
```javascript
// method: Get
// url:
const req = 
{

}
const resp =
{
  
}
```
## Modify my Reservation
```javascript
// method: Post
// url:
const req = 
{

}
const resp =
{
  
}
```



