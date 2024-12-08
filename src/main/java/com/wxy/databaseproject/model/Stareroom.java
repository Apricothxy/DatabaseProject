package com.wxy.databaseproject.model;

public class Stareroom {
    private Integer roomId;
    private String roomType;
    private Integer size;
    private Integer bed_num;
    private Integer bathroom_num;
    private Integer balcony_num;
    private Double price_per_person;
    private String position;

    public Stareroom(String position, Double price_per_person, Integer balcony_num, Integer bathroom_num, Integer bed_num, Integer size, String roomType, Integer roomId) {
        this.position = position;
        this.price_per_person = price_per_person;
        this.balcony_num = balcony_num;
        this.bathroom_num = bathroom_num;
        this.bed_num = bed_num;
        this.size = size;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    public Stareroom() {}

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getBed_num() {
        return bed_num;
    }

    public void setBed_num(Integer bed_num) {
        this.bed_num = bed_num;
    }

    public Integer getBathroom_num() {
        return bathroom_num;
    }

    public void setBathroom_num(Integer bathroom_num) {
        this.bathroom_num = bathroom_num;
    }

    public Integer getBalcony_num() {
        return balcony_num;
    }

    public void setBalcony_num(Integer balcony_num) {
        this.balcony_num = balcony_num;
    }

    public Double getPrice_per_person() {
        return price_per_person;
    }

    public void setPrice_per_person(Double price_per_person) {
        this.price_per_person = price_per_person;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Stareroom{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", size=" + size +
                ", bed_num=" + bed_num +
                ", bathroom_num=" + bathroom_num +
                ", balcony_num=" + balcony_num +
                ", price_per_person=" + price_per_person +
                ", position='" + position + '\'' +
                '}';
    }
}
