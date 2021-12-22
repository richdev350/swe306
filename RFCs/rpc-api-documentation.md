# RPC API Documentation

This documentation regulates the APIs for RPC (Remote Procedure Call).

```javascript
const BASE_URL = `https://localhost:8080`;
const API_URL = `${BASE_URL}/api/`;
```

All request after logged in with credentials.

## Authentication

### login

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
### ?(Sign Out)
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
```

## Get data

### getRoomList

Get RoomList

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

### getReservationByUserId

Get Reservations registered under current user

```javascript
// method: GET
// url: ${API_URL}/getReservationByUserId
const req = 
{

}
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

## Reservation Status
```
status 0: The reservation was made successfully, but the room was not used.
status 1: The reservation was made successfully, and the room was used.
```


