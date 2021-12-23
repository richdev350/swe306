package com.peg6.peg6backend.resp;

import java.util.List;

public class ReservationResp {
    private String startTime, endTime;
    //TODO Change List<String> To List<Integer>
    private List<String> memberList;

    private Integer userId, roomId, reserveId, memberNum, status;


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

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
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

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
