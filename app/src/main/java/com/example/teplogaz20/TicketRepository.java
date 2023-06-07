package com.example.teplogaz20;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TicketRepository {
    private final TicketApi ticketApi;

    // Создание интерфейса для взаимодействия с апи билдером
    public TicketRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apigw.intradesk.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ticketApi = retrofit.create(TicketApi.class);
    }
    // Метод для создания заявки
    public Call<TicketResponse> createTicket(String apiKey, TicketData ticketData) {
        return ticketApi.createTicket(apiKey, ticketData);
    }
}
