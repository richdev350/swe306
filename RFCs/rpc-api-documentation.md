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
  "user": {
    "username": "",
    "studentName": "",
    "role": "",  
  },
  "token": "",
}
```

## Get data

### GetRoomList

Get RoomList with 

```javascript
// method: GET
// url: ${API_URL}/getRoomList


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
