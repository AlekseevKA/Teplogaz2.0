package com.example.teplogaz20;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketResponse {
    private String ticketId;
    private String ticketName;
    private String ticketDescription;

    @SerializedName("@odata.count")
    private int count;

    public String getTicketId() {
        return ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

}
