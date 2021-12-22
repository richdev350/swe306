package com.peg6.peg6backend.req;

public class ReservationReq {
    private String startTime, endTime;
    private String memberList;
    private Integer userId, roomId, reserveId;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMemberList() {
        return memberList;
    }

    public void setMemberList(String memberList) {
        this.memberList = memberList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    @Override
    public String toString() {
        return "ReservationReq{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", memberList='" + memberList + '\'' +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", reserveId=" + reserveId +
                '}';
    }
}
